package com.example.signup_login.domain.quiz.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryQuizListResponse {
    private final List<QuizResponse> quiz;
    private final Long difficulty;

    @Getter
    @AllArgsConstructor
    public static class QuizResponse {
        private final Long id;
        private final String content;
    }
}
