package com.sparta.calendarprojectsnext.domain.comment.repository;

import com.sparta.calendarprojectsnext.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
