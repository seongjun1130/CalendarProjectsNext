package com.sparta.calendarprojectsnext.domain.user.mapper;

import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserLoginResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserReadResponseDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserCreateResponseDto userToUserCreateResponseDto(User user);

    UserReadResponseDto userToUserReadResponseDto(User user);

    UserLoginResponseDto userToUserLoginResponseDto(User user);
}
