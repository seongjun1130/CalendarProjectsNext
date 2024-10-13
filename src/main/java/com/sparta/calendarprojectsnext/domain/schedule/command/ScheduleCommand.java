package com.sparta.calendarprojectsnext.domain.schedule.command;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;

public class ScheduleCommand {

    public static class Create {
        private static String userName;
        private static String title;
        private static String scheduleDetails;

        public static void init(ScheduleCreateRequestDto srcDto) {
            userName = srcDto.getUserName();
            title = srcDto.getTitle();
            scheduleDetails = srcDto.getScheduleDetails();
        }

        public static Schedule toEntity(ScheduleCreateRequestDto srcDto) {
            init(srcDto);
            return Schedule.builder()
                    .userName(userName)
                    .title(title)
                    .scheduleDetails(scheduleDetails)
                    .build();
        }
    }
}
