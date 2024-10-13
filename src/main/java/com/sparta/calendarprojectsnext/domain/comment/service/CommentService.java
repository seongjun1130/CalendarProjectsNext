package com.sparta.calendarprojectsnext.domain.comment.service;

import com.sparta.calendarprojectsnext.domain.comment.command.CommentCommand;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import com.sparta.calendarprojectsnext.domain.comment.mapper.CommentMapper;
import com.sparta.calendarprojectsnext.domain.comment.repository.CommentRepository;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    private final CommentMapper commentMapper;

    public CommentCreateResponseDto createComment(CommentCreateRequestDto ccrDto) {
        Comment comment = CommentCommand.Create.toEntity(ccrDto, scheduleRepository);
        commentRepository.save(comment);
        return commentMapper.commentToCommentCreateResponseDto(comment);
    }
}
