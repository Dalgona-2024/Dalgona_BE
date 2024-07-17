package com.example.signup_login.domain.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(columnDefinition = "INT")
    private Long answer;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(1000)")
    private Category category;

    @NotNull
    @Column(columnDefinition = "VARCHAR(1000)")
    private String commentation;

    @NotNull
    @Column(columnDefinition = "VARCHAR(1000)")
    private String content;

    @NotNull
    @Column(columnDefinition = "INT")
    private Long difficulty;

    public Quiz(Long answer, Category category, String commentation, String content, Long difficulty) {
        this.answer = answer;
        this.category = category;
        this.commentation = commentation;
        this.content = content;
        this.difficulty = difficulty;
    }
}
