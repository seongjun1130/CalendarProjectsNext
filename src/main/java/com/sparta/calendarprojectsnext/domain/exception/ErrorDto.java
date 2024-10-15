package com.sparta.calendarprojectsnext.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto {
    private final HttpStatus status;
    private final String message;
}
