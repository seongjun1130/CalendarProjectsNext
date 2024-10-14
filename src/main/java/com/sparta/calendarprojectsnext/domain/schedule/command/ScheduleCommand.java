package com.sparta.calendarprojectsnext.domain.schedule.command;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;

public class ScheduleCommand {

    public static class Create {
        private static String title;
        private static String scheduleDetails;

        public static Schedule toEntity(ScheduleCreateRequestDto scrDto, UserRepository userRepository) {
            User user = userRepository.findById(scrDto.getUserId()).orElseThrow(() -> new NullPointerException("User Not Found"));
            title = scrDto.getTitle();
            scheduleDetails = scrDto.getScheduleDetails();
            return Schedule.builder()
                    .user(user)
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
