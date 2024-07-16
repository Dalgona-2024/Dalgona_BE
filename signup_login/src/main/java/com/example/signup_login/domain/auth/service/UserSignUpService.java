package com.example.signup_login.domain.auth.service;

import com.example.signup_login.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.entity.UserRepository;
import com.example.signup_login.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UserSignUpRequest request) {

        userFacade.checkUserIdExists(request.getNick());

        userRepository.save(User.builder()
                .nick(request.getNick())
                .password(passwordEncoder.encode(request.getPassword()))
                .build());
    }
}
