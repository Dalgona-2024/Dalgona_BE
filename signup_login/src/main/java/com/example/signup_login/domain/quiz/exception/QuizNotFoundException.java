package com.example.signup_login.domain.quiz.exception;

import com.example.signup_login.global.error.exception.DalgonaException;
import com.example.signup_login.global.error.exception.GlobalErrorCode;

public class QuizNotFoundException extends DalgonaException {
    public static final DalgonaException EXCEPTION = new QuizNotFoundException();

    private QuizNotFoundException() {
        super(GlobalErrorCode.QUIZ_NOT_FOUND);
    }
}
