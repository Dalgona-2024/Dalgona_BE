package com.example.signup_login.domain.quiz.entity.repository;

import com.example.signup_login.domain.quiz.entity.Pick;
import com.example.signup_login.domain.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickRepository extends JpaRepository<Pick, Long> {
    List<Pick> findAllByQuiz(Quiz quiz);
}
