package com.example.signup_login.domain.user.presentation.dto.response;

import com.example.signup_login.domain.quiz.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryDalgonaListResponse {
    private final List<DalgonaResponse> dalgona;

    @Getter
    @AllArgsConstructor
    public static class DalgonaResponse {
        private final Category category;
        private final String dal_content;
    }
}
