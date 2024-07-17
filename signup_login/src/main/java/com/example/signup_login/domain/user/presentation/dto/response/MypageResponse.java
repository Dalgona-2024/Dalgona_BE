package com.example.signup_login.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MypageResponse {
    private final Long id;
    private final String nick;
}
