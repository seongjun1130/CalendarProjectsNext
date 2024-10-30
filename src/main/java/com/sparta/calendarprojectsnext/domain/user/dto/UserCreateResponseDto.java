package com.sparta.calendarprojectsnext.domain.user.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponseDto {
  private Long id;
  private String userName;
  private String email;
  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;
  private String role;
  private String token;
}
