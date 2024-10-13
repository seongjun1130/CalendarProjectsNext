package com.sparta.calendarprojectsnext.domain.comment.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateRequestDto {
    private Long scheduleId;
    private String comment;
    private String userName;
}
