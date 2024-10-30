package com.sparta.calendarprojectsnext.domain.schedule.service;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.SCHEDULE_NOT_FOUND;

import com.sparta.calendarprojectsnext.domain.client.service.WeatherService;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.schedule.command.ScheduleCommand;
import com.sparta.calendarprojectsnext.domain.schedule.dto.*;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.mapper.ScheduleMapper;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import com.sparta.calendarprojectsnext.domain.userschedule.repository.UserScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final UserScheduleRepository userScheduleRepository;
  private final ScheduleMapper scheduleMapper;
  private final WeatherService weatherService;

  public ScheduleCreateResponseDto createSchedule(User user, ScheduleCreateRequestDto scrDto) {
    Schedule schedule =
        ScheduleCommand.Create.toSchedule(scrDto, user, weatherService.getWeather());
    scheduleRepository.save(schedule);
    UserSchedule userSchedule = ScheduleCommand.Create.toUserSchedule(schedule);
    userScheduleRepository.save(userSchedule);
    return scheduleMapper.scheduleToScheduleCreateResponseDto(schedule);
  }

  public ScheduleReadResponseDto getScheduleById(Long scheduleId) {
    Schedule schedule =
        scheduleRepository
            .findById(scheduleId)
            .orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));
    return scheduleMapper.scheduleToScheduleReadResponseDto(schedule);
  }

  public void updateSchedule(Long scheduleId, ScheduleUpdateRequestDto surDto, User user) {
    Schedule schedule = getValidatedAdminSchedule(scheduleId, user);
    ScheduleCommand.Update.executeUpdate(schedule, surDto);
  }

  public void deleteSchedule(Long scheduleId, User user) {
    Schedule schedule = getValidatedAdminSchedule(scheduleId, user);
    scheduleRepository.delete(schedule);
  }

  public Page<ScheduleReadPageResponseDto> getSchedules(int pageNo, int pageSize) {
    PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "modifiedAt");
    Page<Schedule> schedules = scheduleRepository.findAll(pageRequest);
    return schedules.map(
        schedule -> {
          ScheduleReadPageResponseDto srrDto =
              scheduleMapper.scheduleToScheduleReadPageResponseDto(schedule);
          srrDto.setCommentCount((long) schedule.getCommentList().size());
          return srrDto;
        });
  }

  private Schedule getValidatedAdminSchedule(Long scheduleId, User user) {
    user.isAdmin();
    return scheduleRepository
        .findById(scheduleId)
        .orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));
  }
}
