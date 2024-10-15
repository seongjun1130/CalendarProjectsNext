package com.sparta.calendarprojectsnext.domain.user.command;

import com.sparta.calendarprojectsnext.domain.config.PasswordEncoder;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;

public class UserCommand {

    public static class Create {
        private static String userName;
        private static String email;
        private static String passWord;

        public static User toEntity(UserCreateRequestDto ucrDto, PasswordEncoder pwEncoder) {
            userName = ucrDto.getUserName();
            email = ucrDto.getEmail();
            passWord = pwEncoder.encode(ucrDto.getPassWord());
            return User.builder()
                    .userName(userName)
                    .email(email)
                    .passWord(passWord)
                    .build();
        }
    }

    public static class Update {
        private static String userName;
        private static String email;

        public static void executeUpdate(User user, UserUpdateRequestDto uurDto) {
            userName = uurDto.getUserName();
            email = uurDto.getEmail();
            user.setUserName(userName);
            user.setEmail(email);
        }
    }
}
