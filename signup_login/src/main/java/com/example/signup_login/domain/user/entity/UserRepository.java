package com.example.signup_login.domain.user.entity;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByNicke(String nick);
}
