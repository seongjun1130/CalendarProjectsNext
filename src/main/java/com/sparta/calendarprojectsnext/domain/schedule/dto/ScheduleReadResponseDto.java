package com.sparta.calendarprojectsnext.domain.schedule.dto;

import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ScheduleReadResponseDto {
  private Long id;
  private Long userId;
  private String title;
  private String scheduleDetails;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private List<Comment> commentList;
}
