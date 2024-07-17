package com.example.signup_login.domain.user.entity;

import com.example.signup_login.domain.quiz.entity.Category;
import com.example.signup_login.domain.user.entity.repository.DalRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Dalgona(User user, Category category, DalRepository dalRepository) {
        this.user = user;
        this.category = category;
        this.dalContent = generateDalContent(category, dalRepository);
    }

    private String generateDalContent(Category category, DalRepository dalRepository) {
        Optional<Dal> optionalDal = dalRepository.findByCategory(category);
        return optionalDal.map(Dal::getDalContent)
                .orElseThrow(() -> new IllegalArgumentException("No Dal found for category: " + category));
    }
}
