package com.sparta.calendarprojectsnext.domain.comment.command;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import com.sparta.calendarprojectsnext.domain.user.entity.User;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.SCHEDULE_NOT_FOUND;

public class CommentCommand {
  public static class Create {
    private static String comment;
    private static String userName;

    public static Comment toEntity(
        CommentCreateRequestDto ccrDto, ScheduleRepository scheduleRepository, User user) {
      Schedule schedule =
          scheduleRepository
              .findById(ccrDto.getScheduleId())
              .orElseThrow(() -> new CustomException(SCHEDULE_NOT_FOUND));
      comment = ccrDto.getComment();
      userName = user.getUserName();
      return Comment.builder().schedule(schedule).comment(comment).userName(userName).build();
    }
  }

  public static class Update {
    private static String commentDescription;
    private static String userName;

    public static void executeUpdate(User user, Comment comment, CommentUpdateRequestDto curDto) {
      commentDescription = curDto.getComment();
      userName = user.getUserName();
      comment.setComment(commentDescription);
      comment.setUserName(userName);
    }
  }
}
