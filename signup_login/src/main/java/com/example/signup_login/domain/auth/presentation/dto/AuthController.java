package com.example.signup_login.domain.auth.presentation.dto;

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

    @ResponseStatus(HttpStatus.CREATED)// 메서드가 잘 실행 됬을때 CREATED 를 반환
    @PostMapping("/login")
    public UserTokenResponse userSignIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.execute(request);
    }


    @PatchMapping("/reissue/access_token")
    public UserTokenRefreshResponse userTokenRefresh(@RequestHeader("Refresh-Token")String refreshToken) {
            return userTokenRefreshService.execute(refreshToken);
        }

    @RequestMapping(value = "/userId", method = RequestMethod.HEAD)
    public void checkUserIdExist(@NotBlank @RequestParam(name = "userId") String userId) {
        checkUserIdExistsService.execute(userId);
    }
}


