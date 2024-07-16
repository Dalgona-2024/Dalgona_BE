package com.example.signup_login.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DalgonaException extends RuntimeException {
    private final GlobalErrorCode errorCode;
}
