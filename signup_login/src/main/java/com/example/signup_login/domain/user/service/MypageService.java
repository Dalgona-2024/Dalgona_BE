package com.example.signup_login.domain.user.service;

import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.facade.UserFacade;
import com.example.signup_login.domain.user.presentation.dto.response.MypageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MypageService {
    private final UserFacade userFacade;
    @Transactional(readOnly = true)
    public MypageResponse execute() {
        User user = userFacade.getCurrentUser();
        return MypageResponse.builder()
                .id(user.getId())
                .nick(user.getNick())
                .build();
    }
}
