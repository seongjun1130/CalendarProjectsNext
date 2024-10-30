package com.sparta.calendarprojectsnext.domain.userschedule.mapper;

import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleDeleteUserResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserScheduleMapper {
  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "schedule.id", target = "scheduleId")
  UserScheduleAssignResponseDto UserScheduleToUserScheduleDto(UserSchedule userSchedule);

  @Mapping(source = "user.id", target = "userId")
  @Mapping(source = "schedule.id", target = "scheduleId")
  UserScheduleDeleteUserResponseDto UserScheduleToUserScheduleDeleteDto(UserSchedule userSchedule);
}
