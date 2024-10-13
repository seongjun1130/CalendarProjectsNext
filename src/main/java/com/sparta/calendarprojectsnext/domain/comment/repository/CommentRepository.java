package com.sparta.calendarprojectsnext.domain.comment.repository;

import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByScheduleId(Long scheduleId);
}
