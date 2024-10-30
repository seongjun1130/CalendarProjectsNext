package com.sparta.calendarprojectsnext.domain.comment.mapper;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentReadResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
  @Mapping(source = "schedule.id", target = "scheduleId")
  CommentCreateResponseDto commentToCommentCreateResponseDto(Comment comment);

  @Mapping(source = "schedule.id", target = "scheduleId")
  @Mapping(source = "comment.id", target = "commentId")
  CommentReadResponseDto commentToCommentReadResponseDto(Comment comment);
}
