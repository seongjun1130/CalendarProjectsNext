package com.sparta.calendarprojectsnext.domain.schedule.controller;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleCreateResponseDto> createsSchedule(@RequestBody ScheduleCreateRequestDto srcDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scheduleService.createSchedule(srcDto));
    }
}
