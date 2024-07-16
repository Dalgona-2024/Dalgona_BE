package com.example.signup_login.domain.quiz.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnswerResponse {
    private boolean answer;
    private String commentation;
}
