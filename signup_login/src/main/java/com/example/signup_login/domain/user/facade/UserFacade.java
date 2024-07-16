package com.example.signup_login.domain.user.facade;

import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.entity.UserRepository;
import com.example.signup_login.domain.user.exception.AlreadyUserIdExistsException;
import com.example.signup_login.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;
    public User getCurrentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUserId(userId);
    }
    public User getUserByUserId(String nick) {
        return userRepository.findByNick(nick)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
    public void checkUserIdExists(String nick) {
        if (userRepository.findByNick(nick).isPresent()) {
            throw AlreadyUserIdExistsException.EXCEPTION;
        }
    }
}
