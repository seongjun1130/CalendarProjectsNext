package com.sparta.calendarprojectsnext.domain.user.controller;

import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserReadResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserCreateResponseDto> createUser(@RequestBody UserCreateRequestDto ucrDto) {
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
    public ResponseEntity<UserReadResponseDto> getUser(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequestDto uurDto) {
        userService.updateUser(userId, uurDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
