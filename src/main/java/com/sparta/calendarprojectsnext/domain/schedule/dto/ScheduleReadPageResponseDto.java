package com.sparta.calendarprojectsnext.domain.schedule.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ScheduleReadPageResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String scheduleDetails;
    private Long commentCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
