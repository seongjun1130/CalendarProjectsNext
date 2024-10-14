package com.sparta.calendarprojectsnext.domain.user.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserReadResponseDto {
    private Long id;
    private String userName;
    private String email;
}
