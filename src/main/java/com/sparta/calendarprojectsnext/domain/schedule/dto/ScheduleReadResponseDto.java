package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ScheduleReadResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String scheduleDetails;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
