package com.example.signup_login.domain.quiz.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryPickResponse {

    private final List<PickResponse> picks;

    @Getter
    @AllArgsConstructor
    public static class PickResponse {

        private final Long pickId;
        private final Long content;
    }
}
