package com.example.signup_login.global.property.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Base64;

@Getter
@ConfigurationProperties(prefix = "spring.security.jwt")
public class JwtProperties {

    private final String secretKey;
    private final Long accessExp;

    public JwtProperties(String secretKey, Long accessExp) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.accessExp = accessExp;
    }
}
