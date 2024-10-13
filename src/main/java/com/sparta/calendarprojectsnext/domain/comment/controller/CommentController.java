package com.sparta.calendarprojectsnext.domain.comment.controller;

import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateRequestDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentCreateResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.dto.CommentReadResponseDto;
import com.sparta.calendarprojectsnext.domain.comment.service.CommentService;
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

    @GetMapping("/{scheduleId}")
    public ResponseEntity<List<CommentReadResponseDto>> getCommentList(@PathVariable Long scheduleId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.getCommentsList(scheduleId));
    }

}
