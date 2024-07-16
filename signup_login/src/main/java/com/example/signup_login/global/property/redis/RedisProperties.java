package com.example.signup_login.global.property.redis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String host;
    private int port;
    private String password;

    // Spring Boot를 위해 리플렉션을 통한 인스턴스화를 지원하는 기본 생성자
    public RedisProperties() {
    }

    // 모든 필드에 대한 게터와 세터
    // 주의: Lombok의 @Getter는 모든 필드에 대한 게터를 생성합니다

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
