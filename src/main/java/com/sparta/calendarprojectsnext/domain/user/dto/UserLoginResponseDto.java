package com.sparta.calendarprojectsnext.domain.user.dto;

import com.sparta.calendarprojectsnext.domain.user.eunm.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginResponseDto {
    private String token;
    private String userName;
    private Long id;
    private UserRole role;
}
