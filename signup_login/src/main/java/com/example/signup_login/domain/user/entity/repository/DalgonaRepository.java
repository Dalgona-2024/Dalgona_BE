package com.example.signup_login.domain.user.entity.repository;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.user.entity.Dalgona;
import com.example.signup_login.domain.user.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DalgonaRepository extends JpaRepository<Dalgona, Long> {
    List<Dalgona> findByUser(User user);

//    @Query("SELECT COUNT(d) > 0 FROM Dalgona d WHERE d.user = :user AND d.category = :category")
//    boolean existsByUserAndCategory(@Param("user") User user, @Param("category") Category category);
    boolean existsByUserAndCategory(User user, Category category);
}
