package com.example.signup_login.domain.user.entity;

import com.example.signup_login.domain.quiz.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Dalgona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String dalContent;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(1000)")
    private Category category;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Dalgona(User user, Category category) {
        this.user = user;
        this.category = category;
        this.dalContent = generateDalContent(category);
    }

    private String generateDalContent(Category category) {
        return category.name().toLowerCase() + "달고나";
    }
}
