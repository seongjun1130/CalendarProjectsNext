package com.sparta.calendarprojectsnext.domain.exception.eunm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
  // 400 에러
  INVALID_REQUEST(HttpStatus.BAD_REQUEST, "필수 값 누락 및 유효하지않은 값", 400, "ERROR 401"),
  USER_INFO_MISMATCH(HttpStatus.BAD_REQUEST, "사용자 정보 오류", 400, "ERROR 402"),
  TOKEN_NOT_FOUND(HttpStatus.BAD_REQUEST, "토큰이 존재하지 않음", 400, "ERROR 403"),
  NOT_KICK_SELF(HttpStatus.BAD_REQUEST, "자기자신을 강퇴할 수 없음", 400, "ERROR 404"),

  // 401 에러
  LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "로그인 실패", 401, "ERROR 411"),
  INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰", 401, "ERROR 412"),
  ADMIN_KEY_MISMATCH(HttpStatus.UNAUTHORIZED, "유효하지 않은 관리자 키", 401, "ERROR 413"),

  // 403 에러
  NOT_CREATOR(HttpStatus.FORBIDDEN, "작성자가 아님", 403, "ERROR 431"),
  NOT_ADMIN(HttpStatus.FORBIDDEN, "관리자가 아님", 403, "ERROR 432"),

  // 404 에러
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 유저", 404, "ERROR 441"),
  SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 일정", 404, "ERROR 442"),
  COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 댓글", 404, "ERROR 443"),
  ASSIGN_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 담당자", 404, "ERROR 444"),
  USER_SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 중간테이블", 404, "ERROR 445"),
  WEATHER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 일정의 날씨", 404, "ERROR 446"),

  // 409 에러
  ALREADY_ASSIGN_USER(HttpStatus.CONFLICT, "이미 담당자로 배치된 유저", 409, "ERROR 491"),
  ALREADY_EMAIL_USER(HttpStatus.CONFLICT, "이미 사용되는 이메일", 409, "ERROR 492"),
  ALREADY_USERNAME_USER(HttpStatus.CONFLICT, "이미 사용되는 이름", 409, "ERROR 493"),

  // 500 에러
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러", 500, "ERROR 500");

  private final HttpStatus code;
  private final String description;
  private final int status;
  private final String errorCode;
}
