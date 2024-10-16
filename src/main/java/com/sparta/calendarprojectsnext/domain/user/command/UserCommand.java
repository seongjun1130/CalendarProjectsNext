package com.sparta.calendarprojectsnext.domain.user.command;

import com.sparta.calendarprojectsnext.domain.config.PasswordEncoder;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.user.dto.UserCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.dto.UserUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.eunm.UserRole;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.ADMIN_KEY_MISMATCH;

public class UserCommand {

    public static class Create {
        private static String userName;
        private static String email;
        private static String passWord;
        private static UserRole userRole;

        public static User toEntity(UserCreateRequestDto ucrDto, PasswordEncoder pwEncoder, String adKey) {
            userName = ucrDto.getUserName();
            email = ucrDto.getEmail();
            passWord = pwEncoder.encode(ucrDto.getPassWord());
            userRole = UserRole.USER;
            if (ucrDto.isAdmin()) {
                if (!adKey.equals(ucrDto.getAdminKey())) {
                    throw new CustomException(ADMIN_KEY_MISMATCH);
                }
                userRole = UserRole.ADMIN;
            }
            return User.builder()
                    .userName(userName)
                    .email(email)
                    .passWord(passWord)
                    .role(userRole)
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
