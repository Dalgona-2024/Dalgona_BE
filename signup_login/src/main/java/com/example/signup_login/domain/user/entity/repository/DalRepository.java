package com.example.signup_login.domain.user.entity.repository;


import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.user.entity.Dal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DalRepository extends JpaRepository<Dal, Long> {
    Optional<Dal> findByCategory(Category category);
}
