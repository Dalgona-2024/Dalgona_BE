package com.example.signup_login.domain.auth.presentation;

import com.example.signup_login.domain.auth.presentation.dto.requeust.UserSignInRequest;
import com.example.signup_login.domain.auth.presentation.dto.requeust.UserSignUpRequest;
import com.example.signup_login.domain.auth.presentation.dto.response.UserTokenResponse;
import com.example.signup_login.domain.auth.service.UserSignInService;
import com.example.signup_login.domain.auth.service.UserSignUpService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth") // url 에  "auth/" 이하의 값만 오게 함.
public class AuthController {

    private final UserSignInService userSignInService;
    private final UserSignUpService userSignUpService;
//    private final CheckUserIdExistsService checkUserIdExistsService;

    @ResponseStatus(HttpStatus.CREATED)// 메서드가 잘 실행 됬을때 CREATED 를 반환
    @PostMapping("/login")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }

//    @RequestMapping(value = "/userId", method = RequestMethod.HEAD)
//    public void checkUserIdExist(@NotBlank @RequestParam(name = "userId") String userId) {
//        checkUserIdExistsService.execute(userId);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void userSignUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.execute(request);
    }
}


