package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleCreateResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String scheduleDetails;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
