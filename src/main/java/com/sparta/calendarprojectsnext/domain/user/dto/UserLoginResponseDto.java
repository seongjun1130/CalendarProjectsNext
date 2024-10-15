package com.sparta.calendarprojectsnext.domain.user.dto;

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
}
