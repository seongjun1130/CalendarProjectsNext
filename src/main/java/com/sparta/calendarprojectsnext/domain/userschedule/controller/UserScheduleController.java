package com.sparta.calendarprojectsnext.domain.userschedule.controller;

import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.resolver.util.LoginUser;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignRequestDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleDeleteUserRequestDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleDeleteUserResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.service.UserScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user_schedule")
public class UserScheduleController {
    private final UserScheduleService userScheduleService;

    @PostMapping("/assign_user")
    public ResponseEntity<UserScheduleAssignResponseDto> assignUser(@LoginUser User user, @RequestBody @Valid UserScheduleAssignRequestDto uarDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userScheduleService.assignUser(user, uarDto));
    }

    @DeleteMapping("/assign_user")
    public ResponseEntity<UserScheduleDeleteUserResponseDto> deleteAssignUser(@LoginUser User user, @RequestBody @Valid UserScheduleDeleteUserRequestDto sduDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userScheduleService.deleteUser(user, sduDto));
    }
}
