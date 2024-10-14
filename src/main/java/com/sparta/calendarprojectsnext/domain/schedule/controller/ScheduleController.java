package com.sparta.calendarprojectsnext.domain.schedule.controller;

import com.sparta.calendarprojectsnext.domain.schedule.dto.*;
import com.sparta.calendarprojectsnext.domain.schedule.service.ScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping()
    public ResponseEntity<ScheduleCreateResponseDto> createsSchedule(@Valid @RequestBody ScheduleCreateRequestDto scrDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scheduleService.createSchedule(scrDto));
    }

    @GetMapping()
    public ResponseEntity<Page<ScheduleReadPageResponseDto>> getSchedules(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo
            , @RequestParam(defaultValue = "10", value = "pageSize") int pageSize) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scheduleService.getSchedules(pageNo, pageSize));
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleReadResponseDto> getScheduleById(@PathVariable @Positive(message = "ScheduleId 는 0보다 커야합니다.") Long scheduleId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scheduleService.getScheduleById(scheduleId));
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<Void> updateSchedule(@PathVariable @Positive(message = "ScheduleId 는 0보다 커야합니다.") Long scheduleId, @RequestBody @Valid ScheduleUpdateRequestDto surDto) {
        scheduleService.updateSchedule(scheduleId, surDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable @Positive(message = "ScheduleId 는 0보다 커야합니다.") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
