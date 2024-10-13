package com.sparta.calendarprojectsnext.domain.schedule.service;

import com.sparta.calendarprojectsnext.domain.schedule.command.ScheduleCommand;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.mapper.ScheduleMapper;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto srcDto) {
        Schedule schedule = ScheduleCommand.Create.toEntity(srcDto);
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
}
