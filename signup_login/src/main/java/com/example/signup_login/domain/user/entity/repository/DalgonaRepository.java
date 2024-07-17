package com.example.signup_login.domain.user.entity.repository;

import com.example.signup_login.domain.user.entity.Dalgona;
import com.example.signup_login.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DalgonaRepository extends JpaRepository<Dalgona, Long> {
    Optional<Dalgona> findByUser(User user);
}
