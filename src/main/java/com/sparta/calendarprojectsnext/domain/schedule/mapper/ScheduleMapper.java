package com.sparta.calendarprojectsnext.domain.schedule.mapper;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleCreateResponseDto scheduleToScheduleCreateResponseDto(Schedule schedule);

    ScheduleReadResponseDto scheduleToScheduleReadResponseDto(Schedule schedule);
}
