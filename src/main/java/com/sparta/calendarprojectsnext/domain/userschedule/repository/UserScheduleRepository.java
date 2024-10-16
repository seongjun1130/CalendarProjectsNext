package com.sparta.calendarprojectsnext.domain.userschedule.repository;

import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
    boolean existsByUserIdAndScheduleId(Long userId, Long scheduleId);

    boolean existsByUserIdAndRole(Long userId, String role);

    Optional<UserSchedule> findByUserIdAndScheduleId(Long userId, Long scheduleId);
}
