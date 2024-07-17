package com.example.signup_login.domain.quiz.service;

import com.example.signup_login.domain.quiz.entity.repository.UserQuizRepository;
import com.example.signup_login.domain.quiz.presentation.dto.response.SavedQuizListResponse;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SavedQuizService {
    private final UserQuizRepository userQuizRepository;
    private final UserFacade userFacade;
    @Transactional(readOnly = true)
    public SavedQuizListResponse execute() {
        User user = userFacade.getCurrentUser();

        return new SavedQuizListResponse(
                userQuizRepository.findByUser(user).stream()
                        .map(saved -> new SavedQuizListResponse.SavedQuizResponse(saved.getQuiz().getId(), saved.getQuiz().getContent(), saved.getQuiz().getCategory(), saved.getQuiz().getDifficulty(), saved.getQuiz().getAnswer()))
                        .toList()
        );
    }
}
