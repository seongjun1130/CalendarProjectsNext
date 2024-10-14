package com.sparta.calendarprojectsnext.domain.user.controller;

import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserReadResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserCreateResponseDto> createUser(@Valid @RequestBody UserCreateRequestDto ucrDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(ucrDto));
    }

    @GetMapping()
    public ResponseEntity<List<UserReadResponseDto>> getUserList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserList());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserReadResponseDto> getUser(@PathVariable @Positive(message = "UserId 는 0보다 커야합니다.") Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable @Positive(message = "UserId 는 0보다 커야합니다.") Long userId, @Valid @RequestBody UserUpdateRequestDto uurDto) {
        userService.updateUser(userId, uurDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable @Positive(message = "UserId 는 0보다 커야합니다.") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
