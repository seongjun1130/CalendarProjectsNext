package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleCreateRequestDto {
    private String userName;
    private String title;
    private String scheduleDetails;
}
