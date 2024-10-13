package com.sparta.calendarprojectsnext.domain.schedule.mapper;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ScheduleCreateMapper {
    private Long id;
    private String userName;
    private String title;
    private String scheduleDetails;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static ScheduleCreateResponseDto to(Schedule schedule) {
        return ScheduleCreateResponseDto.builder()
                .id(schedule.getId())
                .userName(schedule.getUserName())
                .title(schedule.getTitle())
                .scheduleDetails(schedule.getScheduleDetails())
                .createdAt(schedule.getCreatedAt())
                .modifiedAt(schedule.getModifiedAt())
                .build();
    }
}
