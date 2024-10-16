package com.sparta.calendarprojectsnext.domain.exception;

import com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}
