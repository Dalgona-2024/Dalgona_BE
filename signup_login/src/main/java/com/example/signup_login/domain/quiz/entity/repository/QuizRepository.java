package com.example.signup_login.domain.quiz.entity.repository;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.quiz.entity.Quiz;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

    @Query("select quiz from Quiz quiz where quiz.category = :category and quiz.difficulty = 1 order by RAND() limit 4")
    List<Quiz> findDiffOneByCategoryAndRandom(@Param("category") Category category);

    @Query("select quiz from Quiz quiz where quiz.category = :category and quiz.difficulty = 2 order by RAND() limit 4")
    List<Quiz> findDiffTwoByCategoryAndRandom(@Param("category") Category category);

    @Query("select quiz from Quiz quiz where quiz.category = :category and quiz.difficulty = 3 order by RAND() limit 4")
    List<Quiz> findDiffThreeByCategoryAndRandom(@Param("category") Category category);
}
