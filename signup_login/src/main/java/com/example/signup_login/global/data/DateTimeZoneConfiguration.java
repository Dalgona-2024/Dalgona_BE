package com.example.signup_login.global.data;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class DateTimeZoneConfiguration {
    @PostConstruct
    public void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
}
