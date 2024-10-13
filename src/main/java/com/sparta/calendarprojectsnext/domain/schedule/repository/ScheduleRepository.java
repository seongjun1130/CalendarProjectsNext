package com.sparta.calendarprojectsnext.domain.schedule.repository;

import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
