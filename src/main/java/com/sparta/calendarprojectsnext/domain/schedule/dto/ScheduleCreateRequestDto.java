package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleCreateRequestDto {
    private Long userId;
    private String title;
    private String scheduleDetails;
}
