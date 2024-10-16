package com.sparta.calendarprojectsnext.domain.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CommentReadResponseDto {
    private Long scheduleId;
    private Long commentId;
    private String comment;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
