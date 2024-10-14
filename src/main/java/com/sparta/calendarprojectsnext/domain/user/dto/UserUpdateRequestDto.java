package com.sparta.calendarprojectsnext.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequestDto {
    @NotBlank(message = "닉네임이 비어있습니다.")
    @Size(min = 3, max = 20, message = "닉네임은 3 ~ 20 글자사이로 입력해주세요.")
    private String userName;
    @Email(message = "입력된 이메일의 형태가 올바르지 않습니다.")
    private String email;
}