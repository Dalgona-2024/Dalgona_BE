package com.example.signup_login.global.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class InvalidJwtException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new InvalidJwtException();

    public InvalidJwtException() {
        super(GlobalErrorCode.INVALID_JWT);
    }
}
