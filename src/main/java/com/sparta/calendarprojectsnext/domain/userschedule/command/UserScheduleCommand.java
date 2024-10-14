package com.sparta.calendarprojectsnext.domain.userschedule.command;

import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignRequestDto;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;

import java.time.LocalDateTime;

public class UserScheduleCommand {
    public static class Create {
        public static UserSchedule toUserSchedule(UserScheduleAssignRequestDto uarDto, ScheduleRepository scheduleRepository, UserRepository userRepository) {
            Schedule schedule = scheduleRepository.findById(uarDto.getScheduleId()).orElseThrow(() -> new NullPointerException("Schedule not found"));
            User assignUser = userRepository.findById(uarDto.getAssignUserId()).orElseThrow(() -> new NullPointerException("User Not Found"));
            return UserSchedule.builder()
                    .schedule(schedule)
                    .user(assignUser)
                    .role("assignee")
                    .joinedAt(LocalDateTime.now())
                    .build();
        }
    }
}
