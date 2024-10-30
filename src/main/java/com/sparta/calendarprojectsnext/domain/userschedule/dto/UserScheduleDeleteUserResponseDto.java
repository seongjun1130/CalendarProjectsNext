package com.sparta.calendarprojectsnext.domain.userschedule.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserScheduleDeleteUserResponseDto {
  private Long id;
  private Long scheduleId;
  private Long userId;
}
