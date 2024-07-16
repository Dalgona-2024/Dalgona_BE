package com.example.signup_login.domain.user.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class AlreadyUserIdExistsException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new AlreadyUserIdExistsException();

    private AlreadyUserIdExistsException() {
        super(GlobalErrorCode.ALREADY_NICKNAME_EXIST);
    }
}
