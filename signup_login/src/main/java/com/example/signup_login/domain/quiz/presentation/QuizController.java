package com.example.signup_login.domain.quiz.presentation;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.quiz.presentation.dto.request.QuizRequest;
import com.example.signup_login.domain.quiz.presentation.dto.response.AnswerResponse;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryPickResponse;
import com.example.signup_login.domain.quiz.presentation.dto.response.QueryQuizListResponse;
import com.example.signup_login.domain.quiz.presentation.dto.response.SavedQuizListResponse;
import com.example.signup_login.domain.quiz.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final SolveQuizService solveQuizService;
    private final QueryQuizOneService queryQuizOneService;
    private final QueryQuizTwoService queryQuizTwoService;
    private final QueryQuizThreeService queryQuizThreeService;
    private final QueryPickService queryPickService;
    private final UserQuizService userQuizService;
    private final SavedQuizService savedQuizService;


    public QuizController(SolveQuizService solveQuizService,
                          QueryQuizOneService queryQuizOneService,
                          QueryQuizTwoService queryQuizTwoService,
                          QueryQuizThreeService queryQuizThreeService,
                          QueryPickService queryPickService,
                          UserQuizService userQuizService,
                          SavedQuizService savedQuizService) {
        this.solveQuizService = solveQuizService;
        this.queryQuizOneService = queryQuizOneService;
        this.queryQuizTwoService = queryQuizTwoService;
        this.queryQuizThreeService = queryQuizThreeService;
        this.queryPickService = queryPickService;
        this.userQuizService = userQuizService;
        this.savedQuizService = savedQuizService;
    }

    @GetMapping
    public QueryQuizListResponse queryQuizOne(@RequestParam("category") Category category) {
        return queryQuizOneService.execute(category);
    }

    @GetMapping("/two")
    public QueryQuizListResponse queryQuizTwo(@RequestParam("category") Category category) {
        return queryQuizTwoService.execute(category);
    }

    @GetMapping("/three")
    public QueryQuizListResponse queryQuizThree(@RequestParam("category") Category category) {
        return queryQuizThreeService.execute(category);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{quiz-id}")
    public AnswerResponse solvingQuiz(@PathVariable("quiz-id") Long quizId, @RequestBody @Valid QuizRequest request) {
        return solveQuizService.execute(quizId, request);
    }

    @GetMapping("/pick/{quiz-id}")
    public QueryPickResponse queryPicks(@PathVariable("quiz-id") Long quizId) {
        return queryPickService.execute(quizId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/{quiz-id}")
    public void saveQuiz(@PathVariable("quiz-id") Long quizId) {
        userQuizService.execute(quizId);
    }

    @GetMapping("/saved")
    public SavedQuizListResponse savedQuiz() {
        return savedQuizService.execute();
    }
}
