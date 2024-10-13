package com.sparta.calendarprojectsnext.domain.schedule.command;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ScheduleCreateCommand {
    private String userName;
    private String title;
    private String scheduleDetails;

    public static Schedule from(ScheduleCreateRequestDto srcDto) {
        return Schedule.builder()
                .userName(srcDto.getUserName())
                .title(srcDto.getTitle())
                .scheduleDetails(srcDto.getScheduleDetails())
                .build();
    }
}
