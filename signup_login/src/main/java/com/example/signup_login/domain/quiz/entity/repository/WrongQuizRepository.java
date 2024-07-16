package com.example.signup_login.domain.quiz.entity.repository;


import com.example.signup_login.domain.quiz.entity.WrongQuiz;
import com.example.signup_login.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WrongQuizRepository extends JpaRepository<WrongQuiz, Long> {

    List<WrongQuiz> findByUser(User user);
}
