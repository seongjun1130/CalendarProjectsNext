package com.sparta.calendarprojectsnext.domain.userschedule.dto;

import lombok.*;

import java.time.LocalDateTime;

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
