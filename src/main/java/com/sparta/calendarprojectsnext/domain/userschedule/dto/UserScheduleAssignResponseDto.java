package com.sparta.calendarprojectsnext.domain.userschedule.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserScheduleAssignResponseDto {
  private Long id;
  private Long scheduleId;
  private Long userId;
  private String role;
  private LocalDateTime joinedAt;
}
