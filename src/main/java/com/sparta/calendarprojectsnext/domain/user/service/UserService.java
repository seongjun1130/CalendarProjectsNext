package com.sparta.calendarprojectsnext.domain.user.service;

import com.sparta.calendarprojectsnext.domain.user.command.UserCommand;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.mapper.UserMapper;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
