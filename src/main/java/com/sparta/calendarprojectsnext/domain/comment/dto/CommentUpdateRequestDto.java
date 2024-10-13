package com.sparta.calendarprojectsnext.domain.comment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentUpdateRequestDto {
    private String comment;
    private String userName;
}
