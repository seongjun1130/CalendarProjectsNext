package com.sparta.calendarprojectsnext.domain.comment.controller;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentReadResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.service.CommentService;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentUpdateRequestDto;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.resolver.util.LoginUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
  private final CommentService commentService;

  @PostMapping()
  public ResponseEntity<CommentCreateResponseDto> createComment(
      @LoginUser User user, @RequestBody @Valid CommentCreateRequestDto ccrDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(commentService.createComment(ccrDto, user));
  }

  @GetMapping("/{commentId}")
  public ResponseEntity<CommentReadResponseDto> getCommentList(
      @PathVariable @Positive(message = "CommentId 는 0보다 커야합니다.") Long commentId) {
    return ResponseEntity.status(HttpStatus.OK).body(commentService.getComment(commentId));
  }

  @PutMapping("/{commentId}")
  public ResponseEntity<Void> updateComment(
      @LoginUser User user,
      @PathVariable Long commentId,
      @RequestBody @Valid CommentUpdateRequestDto curDto) {
    commentService.updateComment(user, commentId, curDto);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{commentId}")
  public ResponseEntity<Void> deleteComment(
      @PathVariable @Positive(message = "CommentId 는 0보다 커야합니다.") Long commentId) {
    commentService.deleteComment(commentId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
