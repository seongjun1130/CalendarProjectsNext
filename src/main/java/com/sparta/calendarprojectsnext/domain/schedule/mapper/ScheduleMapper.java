package com.sparta.calendarprojectsnext.domain.schedule.mapper;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadPageResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    @Mapping(source = "user.id", target = "userId")
    ScheduleCreateResponseDto scheduleToScheduleCreateResponseDto(Schedule schedule);

    ScheduleReadResponseDto scheduleToScheduleReadResponseDto(Schedule schedule);

    ScheduleReadPageResponseDto scheduleToScheduleReadPageResponseDto(Schedule schedule);
}
