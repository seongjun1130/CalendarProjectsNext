package com.sparta.calendarprojectsnext.domain.schedule.service;

import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import com.sparta.calendarprojectsnext.domain.comment.mapper.CommentMapper;
import com.sparta.calendarprojectsnext.domain.comment.repository.CommentRepository;
import com.sparta.calendarprojectsnext.domain.comment.service.CommentService;
import com.sparta.calendarprojectsnext.domain.schedule.command.ScheduleCommand;
import com.sparta.calendarprojectsnext.domain.schedule.dto.*;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.mapper.ScheduleMapper;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
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
    private final ScheduleMapper scheduleMapper;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto scrDto) {
        Schedule schedule = ScheduleCommand.Create.toEntity(scrDto);
        scheduleRepository.save(schedule);
        return scheduleMapper.scheduleToScheduleCreateResponseDto(schedule);
    }

    public ScheduleReadResponseDto getScheduleById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("Schedule not found"));
        return scheduleMapper.scheduleToScheduleReadResponseDto(schedule);
    }

    public void updateSchedule(Long scheduleId, ScheduleUpdateRequestDto surDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("Schedule not found"));
        ScheduleCommand.Update.executeUpdate(schedule, surDto);
    }

    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }

    public Page<ScheduleReadPageResponseDto> getSchedules(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.Direction.DESC, "modifiedAt");
        Page<Schedule> schedules = scheduleRepository.findAll(pageRequest);
        return schedules.map(schedule -> {
            ScheduleReadPageResponseDto srrDto = scheduleMapper.scheduleToScheduleReadPageResponseDto(schedule);
            srrDto.setCommentCount((long) schedule.getCommentList().size());
            return srrDto;
        });
    }
}
