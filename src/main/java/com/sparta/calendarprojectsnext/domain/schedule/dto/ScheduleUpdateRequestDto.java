package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleUpdateRequestDto {
    private String title;
    private String scheduleDetails;
}
