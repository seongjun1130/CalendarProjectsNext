package com.sparta.calendarprojectsnext.domain.userschedule.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserScheduleDeleteUserRequestDto {
    @NotNull(message = "일정 ID 를 입력해주세요.")
    private Long scheduleId;
    @NotNull(message = "삭제할 담당자 ID 를 입력해주세요.")
    private Long deleteUserId;
}