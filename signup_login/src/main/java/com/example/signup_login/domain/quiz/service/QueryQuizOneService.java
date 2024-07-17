package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.quiz.entity.repository.QuizRepository;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryQuizListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryQuizOneService {
    private final QuizRepository quizRepository;

    @Transactional(readOnly = true)
    public QueryQuizListResponse execute(Category category) {
        List<QueryQuizListResponse.QuizResponse> quizResponses = quizRepository.findDiffOneByCategoryAndRandom(category).stream()
                .map(quiz -> new QueryQuizListResponse.QuizResponse(quiz.getId(), quiz.getContent()))
                .collect(Collectors.toList());

        return new QueryQuizListResponse(quizResponses, 1L);
    }
}
