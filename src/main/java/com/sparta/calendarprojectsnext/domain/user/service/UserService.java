package com.sparta.calendarprojectsnext.domain.user.service;

import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.user.command.UserCommand;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserReadResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.mapper.UserMapper;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.USER_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserCreateResponseDto createUser(UserCreateRequestDto ucrDto) {
        User user = UserCommand.Create.toEntity(ucrDto);
        userRepository.save(user);
        return userMapper.userToUserCreateResponseDto(user);
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
}
