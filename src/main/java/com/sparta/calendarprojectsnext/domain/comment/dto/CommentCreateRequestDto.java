package com.sparta.calendarprojectsnext.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateRequestDto {
    @NotNull(message = "일정 ID 를 입력해주세요.")
    @Positive(message = "ScheduleId 는 0보다 커야합니다.")
    private Long scheduleId;
    @NotBlank(message = "댓글을 입력 해 주세요.")
    @Size(min = 2, max = 100, message = "댓글은 2 ~ 100 글자사이로 입력해주세요.")
    private String comment;
}
