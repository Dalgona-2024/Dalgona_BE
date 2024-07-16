package com.example.signup_login.domain.auth.presentation.dto.requeust;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotBlank(message = "nick는 Null, 공백을 허용하지 않습니다.")
    private  String nick;

    @NotBlank(message = "password는 Null, 공백을 허용하지 않습니다.")
    private String password;
}
