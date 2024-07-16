package com.example.signup_login.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String nick;

    @NotNull
    private String password;

    @Builder
    public User(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public void UserSignUp(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
