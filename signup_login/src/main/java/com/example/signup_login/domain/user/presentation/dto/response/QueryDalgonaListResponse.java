package com.example.signup_login.domain.user.presentation.dto.response;

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
        private final Long id;
        private final String dalContent;
    }
}
