package com.example.signup_login.global.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class UserNotFoundException extends DalgonaException {

    public static final DalgonaException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(GlobalErrorCode.USER_NOT_FOUND);
    }
}
