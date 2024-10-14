package com.sparta.calendarprojectsnext.domain.userschedule.entity;

import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "userschedule")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "role", nullable = false)
    private String role;

    private LocalDateTime joinedAt;

    public boolean isValidateCreator(Long creatorId) {
        if (!this.schedule.getUser().getId().equals(creatorId)) {
            return true;
        }
        return false;
    }
}
