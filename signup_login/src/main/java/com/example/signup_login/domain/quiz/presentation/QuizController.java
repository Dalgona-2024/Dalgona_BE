package com.example.signup_login.domain.quiz.presentation;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.quiz.presentation.dto.request.QuizRequest;
import com.example.signup_login.domain.quiz.presentation.dto.response.AnswerResponse;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryQuizListResponse;
import com.example.signup_login.domain.quiz.presentation.dto.response.SavedQuizListResponse;
import com.example.signup_login.domain.quiz.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final SolveQuizService solveQuizService;
    private final QueryQuizOneService queryQuizOneService;
    private final QueryQuizTwoService queryQuizTwoService;
    private final QueryQuizThreeService queryQuizThreeService;
    private final SavedQuizService savedQuizService;

    @GetMapping
    public QueryQuizListResponse getQuizOne(@RequestParam("category") Category category) {
        return queryQuizOneService.execute(category);
    }

    @GetMapping("/two")
    public QueryQuizListResponse getQuizTwo(@RequestParam("category") Category category) {
        return queryQuizTwoService.execute(category);
    }

    @GetMapping("/three")
    public QueryQuizListResponse getQuizThree(@RequestParam("category") Category category) {
        return queryQuizThreeService.execute(category);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{quiz-id}")
    public AnswerResponse solveQuiz(@PathVariable("quiz-id") Long quizId, @RequestBody @Valid QuizRequest request) {
        return solveQuizService.execute(quizId, request);
    }

    @GetMapping("/saved")
    public SavedQuizListResponse getSavedQuizzes() {
        return savedQuizService.execute();
    }
}
