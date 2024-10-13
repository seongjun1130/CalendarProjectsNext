package com.sparta.calendarprojectsnext.domain.schedule.service;

import com.sparta.calendarprojectsnext.domain.schedule.command.ScheduleCommand;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.mapper.ScheduleMapper;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto scrDto) {
        Schedule schedule = ScheduleCommand.Create.toEntity(scrDto);
        scheduleRepository.save(schedule);
        return scheduleMapper.scheduleToScheduleCreateResponseDto(schedule);
    }

    public List<ScheduleReadResponseDto> getSchedulesList() {
        return scheduleRepository.findAll().stream().map(scheduleMapper::scheduleToScheduleReadResponseDto).toList();
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
}
