package com.sparta.calendarprojectsnext.domain.userschedule.repository;

import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
}
