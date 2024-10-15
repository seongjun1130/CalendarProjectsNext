package com.sparta.calendarprojectsnext.domain.exception.eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 400 에러
    NOT_NULL(HttpStatus.BAD_REQUEST, "필수 값 누락"),
    USER_INFO_MISMATCH(HttpStatus.BAD_REQUEST, "사용자 정보 오류"),

    // 401 에러
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "로그인 실패"),

    // 403 에러
    NOT_CREATOR(HttpStatus.FORBIDDEN, "작성자가 아님"),

    // 404 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 유저"),
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 일정"),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 댓글"),

    // 409 에러
    ALREADY_ASSIGN_USER(HttpStatus.CONFLICT, "이미 담당자로 배치된 유저"),
    ALREADY_EMAIL_USER(HttpStatus.CONFLICT, "이미 사용되는 이메일"),
    ALREADY_USERNAME_USER(HttpStatus.CONFLICT, "이미 사용되는 이름"),

    // 500 에러
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러");

    private final HttpStatus code;
    private final String description;
}
