package com.sparta.calendarprojectsnext.domain.user.controller;

import com.sparta.calendarprojectsnext.domain.jwt.JwtUtil;
import com.sparta.calendarprojectsnext.domain.user.dto.*;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.resolver.util.LoginUser;
import com.sparta.calendarprojectsnext.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtUtil jwtUtil;

    @PostMapping("/registration")
    public ResponseEntity<UserCreateResponseDto> createUser(@Valid @RequestBody UserCreateRequestDto ucrDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(ucrDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> logIn(@Valid @RequestBody UserLoginRequestDto ulrDto, HttpServletResponse res) {
        UserLoginResponseDto resDto = userService.logIn(ulrDto);
        String token = jwtUtil.createToken(resDto.getId(), resDto.getRole());
        jwtUtil.addJwtToCookie(token, res);
        resDto.setToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(resDto);
    }

    @GetMapping()
    public ResponseEntity<List<UserReadResponseDto>> getUserList() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserList());
    }

    @GetMapping("/my_profile")
    public ResponseEntity<UserReadResponseDto> getMyProfile(@LoginUser User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(user.getId()));
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
