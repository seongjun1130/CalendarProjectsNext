package com.sparta.calendarprojectsnext.domain.user.entity;

import com.sparta.calendarprojectsnext.domain.audit.Auditable;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, length = 20)
    private String userName;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<UserSchedule> userSchedules = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Schedule> schedules = new ArrayList<>();
}
