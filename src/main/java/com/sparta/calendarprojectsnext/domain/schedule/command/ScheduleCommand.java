package com.sparta.calendarprojectsnext.domain.schedule.command;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;

public class ScheduleCommand {

    public static class Create {
        private static String userName;
        private static String title;
        private static String scheduleDetails;

        public static Schedule toEntity(ScheduleCreateRequestDto scrDto) {
            userName = scrDto.getUserName();
            title = scrDto.getTitle();
            scheduleDetails = scrDto.getScheduleDetails();
            return Schedule.builder()
                    .userName(userName)
                    .title(title)
                    .scheduleDetails(scheduleDetails)
                    .build();
        }
    }

    public static class Update {
        private static String title;
        private static String scheduleDetails;

        public static void executeUpdate(Schedule schedule, ScheduleUpdateRequestDto surDto) {
            title = surDto.getTitle();
            scheduleDetails = surDto.getScheduleDetails();
            schedule.setTitle(title);
            schedule.setScheduleDetails(scheduleDetails);
        }
    }
}
