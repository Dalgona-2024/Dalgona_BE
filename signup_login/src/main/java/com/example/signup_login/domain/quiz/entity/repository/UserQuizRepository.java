package com.example.signup_login.domain.quiz.entity.repository;

import com.example.signup_login.domain.quiz.entity.UserQuiz;
import com.example.signup_login.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
    List<UserQuiz> findByUser(User user);

    boolean existsByUserIdAndQuizId(Long userId, Long quizId);
}
