package com.sparta.calendarprojectsnext.domain.schedule.controller;

import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleReadResponseDto;
import com.sparta.calendarprojectsnext.domain.schedule.dto.ScheduleUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleCreateResponseDto> createsSchedule(@RequestBody ScheduleCreateRequestDto scrDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scheduleService.createSchedule(scrDto));
    }

    @GetMapping()
    public ResponseEntity<List<ScheduleReadResponseDto>> getSchedulesList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scheduleService.getSchedulesList());
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleReadResponseDto> getScheduleById(@PathVariable Long scheduleId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scheduleService.getScheduleById(scheduleId));
    }


    @PutMapping("/{scheduleId}")
    public ResponseEntity<Void> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto surDto) {
        scheduleService.updateSchedule(scheduleId, surDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
