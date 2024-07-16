package com.example.signup_login.domain.auth.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class PasswordMisMatchException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new PasswordMisMatchException();

    public PasswordMisMatchException() {
        super(GlobalErrorCode.PASSWORD_MISMATCH);
    }
}
