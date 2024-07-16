package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryQuizListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryQuizOneService {
    private final QuizRepository quizRepository;

    @Transactional(readOnly = true)
    public QueryQuizListResponse execute(Category category) {
        return new QueryQuizListResponse(
                quizRepository.findDiffOneByCategoryAndRandom(category).stream()
                        .map(quiz -> new QueryQuizListResponse.QuizResponse(quiz.getId(), quiz.getContent()))
                        .toList()
        );
    }
}
