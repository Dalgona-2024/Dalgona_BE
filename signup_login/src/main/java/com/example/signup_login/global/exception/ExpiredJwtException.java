package com.example.signup_login.global.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class ExpiredJwtException extends DalgonaException {
    public static final ExpiredJwtException EXCEPTION = new ExpiredJwtException();

    public ExpiredJwtException() {
        super(GlobalErrorCode.EXPIRED_JWT);
    }
}
