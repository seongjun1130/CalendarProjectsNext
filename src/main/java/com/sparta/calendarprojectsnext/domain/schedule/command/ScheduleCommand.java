package com.sparta.calendarprojectsnext.domain.schedule.command;

import com.sparta.calendarprojectsnext.domain.client.service.WeatherService;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;

import java.time.LocalDateTime;

public class ScheduleCommand {

  public static class Create {
    private static String title;
    private static String scheduleDetails;

    public static Schedule toSchedule(ScheduleCreateRequestDto scrDto, User user, String weather) {
      title = scrDto.getTitle();
      scheduleDetails = scrDto.getScheduleDetails();
      return Schedule.builder()
          .user(user)
          .title(title)
          .scheduleDetails(scheduleDetails)
          .weather(weather)
          .build();
    }

    public static UserSchedule toUserSchedule(Schedule schedule) {
      return UserSchedule.builder()
          .user(schedule.getUser())
          .schedule(schedule)
          .role("creator")
          .joinedAt(LocalDateTime.now())
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
