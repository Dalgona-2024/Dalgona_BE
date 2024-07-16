package com.example.signup_login.domain.quiz.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class ConflictException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new ConflictException();
    public ConflictException() {
        super(GlobalErrorCode.CONFLICT_EXCEPTION);
    }
}
