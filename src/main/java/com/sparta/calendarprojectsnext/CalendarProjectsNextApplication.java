package com.sparta.calendarprojectsnext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CalendarProjectsNextApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarProjectsNextApplication.class, args);
    }

}
