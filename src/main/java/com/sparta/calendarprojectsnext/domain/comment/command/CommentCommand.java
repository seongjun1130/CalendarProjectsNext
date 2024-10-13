package com.sparta.calendarprojectsnext.domain.comment.command;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import com.sparta.calendarprojectsnext.domain.schedule.entity.Schedule;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;

public class CommentCommand {
    public static class Create {
        private static Long scheduleId;
        private static String comment;
        private static String userName;

        public static Comment toEntity(CommentCreateRequestDto ccrDto, ScheduleRepository scheduleRepository) {
            Schedule schedule = scheduleRepository.findById(ccrDto.getScheduleId()).orElseThrow(() -> new NullPointerException("Schedule not found"));
            scheduleId = ccrDto.getScheduleId();
            comment = ccrDto.getComment();
            userName = ccrDto.getUserName();
            return Comment.builder()
                    .schedule(schedule)
                    .comment(comment)
                    .userName(userName)
                    .build();
        }
    }

    public static class Update {
        private static String commentDescription;
        private static String userName;

        public static void executeUpdate(Comment comment, CommentUpdateRequestDto curDto) {
            commentDescription = curDto.getComment();
            userName = curDto.getUserName();
            comment.setComment(commentDescription);
            comment.setUserName(userName);
        }
    }
}
