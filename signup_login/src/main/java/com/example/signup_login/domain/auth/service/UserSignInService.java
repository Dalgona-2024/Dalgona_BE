package com.example.signup_login.domain.auth.service;

import com.example.signup_login.domain.auth.exception.PasswordMisMatchException;
import com.example.signup_login.domain.auth.presentation.dto.requeust.UserSignInRequest;
import com.example.signup_login.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.entity.UserRepository;
import com.example.signup_login.global.exception.UserNotFoundException;
import com.example.signup_login.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserTokenResponse execute(UserSignInRequest request) {
        User user = userRepository.findByNick(request.getNick())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getNick());

        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
