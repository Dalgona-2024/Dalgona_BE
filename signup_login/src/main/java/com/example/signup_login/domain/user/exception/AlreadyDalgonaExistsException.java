package com.example.signup_login.domain.user.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class AlreadyDalgonaExistsException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new AlreadyDalgonaExistsException();
    private AlreadyDalgonaExistsException() {
        super(GlobalErrorCode.AlREADY_DALGONA_EXIST);
    }
}
