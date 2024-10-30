package com.sparta.calendarprojectsnext.domain.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCreateResponseDto {
  private Long id;
  private Long scheduleId;
  private String comment;
  private String userName;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
}
