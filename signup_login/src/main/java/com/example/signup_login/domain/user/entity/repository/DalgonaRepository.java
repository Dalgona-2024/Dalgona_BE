package com.example.signup_login.domain.user.entity.repository;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.user.entity.Dalgona;
import com.example.signup_login.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DalgonaRepository extends JpaRepository<Dalgona, Long> {
    List<Dalgona> findByUser(User user);

    Boolean findByUserAndCategory(User user, Category category);
}
