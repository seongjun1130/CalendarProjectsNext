package com.sparta.calendarprojectsnext.domain.schedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleCreateRequestDto {
    @NotBlank(message = "일정에 대한 제목을 입력해주세요.")
    @Size(min = 2, max = 50, message = "일정의 제목은 2 ~ 50 글자사이로 입력해주세요.")
    private String title;
    @NotBlank(message = "일정의 상세한 내용을 입력해주세요.")
    @Size(min = 2, max = 255, message = "일정은 2 ~ 255 글자사이로 입력해주세요.")
    private String scheduleDetails;
}
