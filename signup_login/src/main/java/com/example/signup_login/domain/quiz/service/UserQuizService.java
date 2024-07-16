package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Quiz;
import com.example.signup_login.domain.quiz.entity.UserQuiz;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.entity.repository.UserQuizRepository;
import com.example.signup_login.domain.quiz.exception.ConflictException;
import com.example.signup_login.domain.quiz.exception.QuizNotFoundException;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserQuizService {
    private final QuizRepository quizRepository;
    private final UserQuizRepository userQuizRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long quizId) {
        User user = userFacade.getCurrentUser();
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);

        if (userQuizRepository.existsByUserIdAndQuizId(user.getId(), quiz.getId())) {
            throw ConflictException.EXCEPTION;
        }

        userQuizRepository.save(new UserQuiz(user, quiz));

    }
}
