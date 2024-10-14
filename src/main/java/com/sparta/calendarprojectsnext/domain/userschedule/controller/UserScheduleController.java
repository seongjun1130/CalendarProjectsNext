package com.sparta.calendarprojectsnext.domain.userschedule.controller;

import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignRequestDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.service.UserScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user_schedule")
public class UserScheduleController {
    private final UserScheduleService userScheduleService;

    @PostMapping("/assign_user")
    public ResponseEntity<UserScheduleAssignResponseDto> assignUser(@RequestBody @Valid UserScheduleAssignRequestDto uarDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userScheduleService.assignUser(uarDto));
    }
}
