package com.sparta.calendarprojectsnext.domain.schedule.service;

import com.sparta.calendarprojectsnext.domain.schedule.command.ScheduleCreateCommand;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.mapper.ScheduleCreateMapper;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 리퀘DTO -> 커맨드 -> 엔티티 -> 매퍼 -> 리스폰스 DTO
    public ScheduleCreateResponseDto createSchedule(ScheduleCreateRequestDto srcDto) {
        // Dto -> Entity
        Schedule schedule = ScheduleCreateCommand.from(srcDto);
        // Db Save
        scheduleRepository.save(schedule);
        // Entity -> Dto
        return ScheduleCreateMapper.to(schedule);
    }
}
