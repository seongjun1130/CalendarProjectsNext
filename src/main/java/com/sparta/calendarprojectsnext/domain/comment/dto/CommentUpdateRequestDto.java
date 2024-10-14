package com.sparta.calendarprojectsnext.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentUpdateRequestDto {
    @NotBlank(message = "댓글을 입력 해 주세요.")
    @Size(min = 2, max = 100, message = "댓글은 2 ~ 100 글자사이로 입력해주세요.")
    private String comment;
    @NotBlank(message = "닉네임을 입력 해 주세요.")
    @Size(min = 2, max = 20, message = "닉네임은 2 ~ 20 글자사이로 입력해주세요.")
    private String userName;
}
