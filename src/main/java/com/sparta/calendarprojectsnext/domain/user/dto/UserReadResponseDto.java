package com.sparta.calendarprojectsnext.domain.user.dto;

import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserReadResponseDto {
    private Long id;
    private String userName;
    private String email;
    private String role;
    private List<Schedule> schedules;
}
