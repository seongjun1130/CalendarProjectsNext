package com.sparta.calendarprojectsnext.domain.user.service;

import com.sparta.calendarprojectsnext.domain.config.PasswordEncoder;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.user.command.UserCommand;
import com.sparta.calendarprojectsnext.domain.user.dto.*;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.mapper.UserMapper;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.*;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_KEY = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    public UserCreateResponseDto createUser(UserCreateRequestDto ucrDto) {
        if (userRepository.existsByEmail(ucrDto.getEmail())) {
            throw new CustomException(ALREADY_EMAIL_USER);
        }
        if (userRepository.existsByUserName(ucrDto.getUserName())) {
            throw new CustomException(ALREADY_USERNAME_USER);
        }
        User user = UserCommand.Create.toEntity(ucrDto, passwordEncoder,ADMIN_KEY);
        userRepository.save(user);
        return userMapper.userToUserCreateResponseDto(user);
    }

    public UserLoginResponseDto logIn(UserLoginRequestDto ulrDto) {
        User user = userRepository.findByEmail(ulrDto.getEmail()).orElseThrow(() -> new CustomException(LOGIN_FAILED));
        if (!user.isValidPassword(ulrDto.getPassWord(), passwordEncoder)) {
            throw new CustomException(LOGIN_FAILED);
        }
        return userMapper.userToUserLoginResponseDto(user);
    }

    public UserReadResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        return userMapper.userToUserReadResponseDto(user);
    }

    public List<UserReadResponseDto> getUserList() {
        return userRepository.findAll().stream().map(userMapper::userToUserReadResponseDto).toList();
    }

    public void updateUser(Long userId, UserUpdateRequestDto uurDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        UserCommand.Update.executeUpdate(user, uurDto);
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        userRepository.delete(user);
    }

    public User getLogInUser(String token) {
        return userRepository.findById(Long.valueOf(token)).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
    }
}
