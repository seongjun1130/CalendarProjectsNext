package com.sparta.calendarprojectsnext.domain.client.service;

import com.sparta.calendarprojectsnext.domain.client.dto.WeatherResponseDto;
import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.WEATHER_NOT_FOUND;

@Service
public class WeatherService {
  private final RestTemplate restTemplate;

  public WeatherService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  public String getWeather() {
    LocalDate today = LocalDate.now();
    String date = today.format(DateTimeFormatter.ofPattern("MM-dd"));
    URI uri =
        UriComponentsBuilder.fromUriString("https://f-api.github.io")
            .path("/f-api/weather.json")
            .encode()
            .build()
            .toUri();
    ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
    return fromJSONtoItems(response.getBody()).stream()
        .filter(weatherResponseDto -> weatherResponseDto.getDate().equals(date))
        .map(WeatherResponseDto::getWeather)
        .findFirst()
        .orElseThrow(() -> new CustomException(WEATHER_NOT_FOUND));
  }

  public List<WeatherResponseDto> fromJSONtoItems(String responseEntity) {
    JSONArray items = new JSONArray(responseEntity);
    List<WeatherResponseDto> weatherList = new ArrayList<>();

    for (Object item : items) {
      WeatherResponseDto weatherDto = new WeatherResponseDto((JSONObject) item);
      weatherList.add(weatherDto);
    }
    return weatherList;
  }
}
