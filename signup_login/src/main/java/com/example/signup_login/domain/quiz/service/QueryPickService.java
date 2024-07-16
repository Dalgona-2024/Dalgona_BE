package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Quiz;
import com.example.signup_login.domain.quiz.entity.repository.PickRepository;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.exception.QuizNotFoundException;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryPickResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryPickService {

    private final PickRepository pickRepository;
    private final QuizRepository quizRepository;

    @Transactional(readOnly = true)
    public QueryPickResponse execute(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> QuizNotFoundException.EXCEPTION);

        return new QueryPickResponse(
                pickRepository.findAllByQuiz(quiz).stream()
                        .map(pick -> new QueryPickResponse.PickResponse(pick.getId(), pick.getContent()))
                        .toList()
        );
    }
}