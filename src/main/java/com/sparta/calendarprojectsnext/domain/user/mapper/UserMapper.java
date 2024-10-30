package com.sparta.calendarprojectsnext.domain.user.mapper;

import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserLoginResponseDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserReadResponseDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    // Entity -> ResponseDto 필드값 매칭을 통한 맵핑 진행
    UserCreateResponseDto userToUserCreateResponseDto(User user);

    UserReadResponseDto userToUserReadResponseDto(User user);

    UserLoginResponseDto userToUserLoginResponseDto(User user);
}
