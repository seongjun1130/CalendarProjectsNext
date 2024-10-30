package com.sparta.calendarprojectsnext.domain.userschedule.entity;

import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.NOT_CREATOR;

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

public void isValidateCreator(Long creatorId) {
    if (!this.schedule.getUser().getId().equals(creatorId)) {
        throw new CustomException(NOT_CREATOR);
    }
}

}
