package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Quiz;
import com.example.signup_login.domain.quiz.entity.UserQuiz;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.entity.repository.UserQuizRepository;
import com.example.signup_login.domain.quiz.exception.QuizNotFoundException;
import com.example.signup_login.domain.quiz.presentation.dto.request.QuizRequest;
import com.example.signup_login.domain.quiz.presentation.dto.response.AnswerResponse;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SolveQuizService {
    private final QuizRepository quizRepository;
    private final UserFacade userFacade;
    private final UserQuizRepository userQuizRepository;

    @Transactional
    public AnswerResponse execute(Long quizId, QuizRequest request) {
        User user = userFacade.getCurrentUser();
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);
        boolean isCorrect = quiz.getAnswer().equals(request.getPick());

        if (!isCorrect) {
            userQuizRepository.save(new UserQuiz(user, quiz));
        }

        return AnswerResponse.builder()
                .answer(isCorrect)
                .commentation(quiz.getCommentation())
                .build();
    }
}
