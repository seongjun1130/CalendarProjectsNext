package com.sparta.calendarprojectsnext.domain.exception.controller;

import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.exception.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.INTERNAL_SERVER_ERROR;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CustomException.class})
    protected ResponseEntity<ErrorDto> handleCustomException(CustomException e, HttpServletRequest req) {
        log.error("url:{}, trace:{}", req.getRequestURI(), e.getStackTrace());
        return new ResponseEntity<>(new ErrorDto(e.getErrorCode().getCode(), e.getErrorCode().getDescription()), HttpStatus.valueOf(e.getErrorCode().getCode().value()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorDto> handleValidationException(MethodArgumentNotValidException e, HttpServletRequest req) {
        log.error("url:{}, trace:{}", req.getRequestURI(), e.getStackTrace());
        return new ResponseEntity<>(new ErrorDto((HttpStatus) e.getStatusCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()), HttpStatus.valueOf(e.getStatusCode().value()));
    }
}
