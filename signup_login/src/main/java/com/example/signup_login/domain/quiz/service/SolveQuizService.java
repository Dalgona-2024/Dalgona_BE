package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Pick;
import com.example.signup_login.domain.quiz.entity.Quiz;
import com.example.signup_login.domain.quiz.entity.WrongQuiz;
import com.example.signup_login.domain.quiz.entity.repository.PickRepository;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.entity.repository.WrongQuizRepository;
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
    private final WrongQuizRepository wrongQuizRepository;
    private final PickRepository pickRepository;

    @Transactional
    public AnswerResponse execute(Long quizId, QuizRequest request) {
        User user = userFacade.getCurrentUser();
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);
        Pick pick = pickRepository.findById(request.getPickId())
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);

        wrongQuizRepository.save(new WrongQuiz(quiz, pick, user));

        return AnswerResponse.builder()
                .answer(quiz.getAnswer().equals(request.getPickId()))
                .commentation(quiz.getCommentation())
                .build();
    }
}
