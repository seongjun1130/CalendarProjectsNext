package com.sparta.calendarprojectsnext.domain.client.dto;

import lombok.*;
import org.json.JSONObject;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class WeatherResponseDto {
  private String date;
  private String weather;

  public WeatherResponseDto(JSONObject jsonObject) {
    this.date = jsonObject.getString("date");
    this.weather = jsonObject.getString("weather");
  }
}
