package com.sparta.calendarprojectsnext.domain.userschedule.repository;

import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
  boolean existsByUserIdAndScheduleId(Long userId, Long scheduleId);

  boolean existsByUserIdAndRole(Long userId, String role);

  Optional<UserSchedule> findByUserIdAndScheduleId(Long userId, Long scheduleId);
}
