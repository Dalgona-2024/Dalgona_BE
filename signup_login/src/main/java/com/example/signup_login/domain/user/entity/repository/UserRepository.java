package com.example.signup_login.domain.user.entity.repository;

import com.example.signup_login.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByNick(String nick);
}