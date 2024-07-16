package com.example.signup_login.global.property.redis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private final String host;
    private final int port;
    private final String password;

}
