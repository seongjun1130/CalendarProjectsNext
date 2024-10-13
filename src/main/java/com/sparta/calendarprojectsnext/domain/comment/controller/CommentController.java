package com.sparta.calendarprojectsnext.domain.comment.controller;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentReadResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.service.CommentService;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<CommentCreateResponseDto> createComment(@RequestBody CommentCreateRequestDto ccrDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.createComment(ccrDto));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentReadResponseDto> getCommentList(@PathVariable Long commentId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.getComment(commentId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto curDto) {
        commentService.updateComment(commentId, curDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}