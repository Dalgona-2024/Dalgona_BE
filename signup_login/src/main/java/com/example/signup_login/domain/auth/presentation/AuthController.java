package com.example.signup_login.domain.auth.presentation;

import com.example.signup_login.domain.auth.presentation.dto.request.UserSignInRequest;
import com.example.signup_login.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.example.signup_login.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.signup_login.domain.auth.service.UserSignInService;
import com.example.signup_login.domain.auth.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserSignInService userSignInService;
    private final UserSignUpService userSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }
}


