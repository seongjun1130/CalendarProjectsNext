package com.sparta.calendarprojectsnext.domain.user.command;

import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;

public class UserCommand {

    public static class Create {
        private static String userName;
        private static String email;

        public static User toEntity(UserCreateRequestDto ucrDto) {
            userName = ucrDto.getUserName();
            email = ucrDto.getEmail();
            return User.builder()
                    .userName(userName)
                    .email(email)
                    .build();
        }
    }
}
