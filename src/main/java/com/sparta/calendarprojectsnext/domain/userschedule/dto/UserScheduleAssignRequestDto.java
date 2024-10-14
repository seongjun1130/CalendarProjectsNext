package com.sparta.calendarprojectsnext.domain.userschedule.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserScheduleAssignRequestDto {
    private Long scheduleId;
    private Long createUserId;
    private Long assignUserId;
}
