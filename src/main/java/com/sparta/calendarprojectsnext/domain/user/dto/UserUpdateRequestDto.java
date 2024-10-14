package com.sparta.calendarprojectsnext.domain.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequestDto {
    private String userName;
    private String email;
}
