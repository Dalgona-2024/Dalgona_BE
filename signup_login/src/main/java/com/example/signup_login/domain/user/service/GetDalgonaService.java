package com.example.signup_login.domain.user.service;

import com.example.signup_login.domain.user.entity.Dalgona;
import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.entity.repository.DalgonaRepository;
import com.example.signup_login.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GetDalgonaService {
    private final UserFacade userFacade;
    private final DalgonaRepository dalgonaRepository;

    @Transactional(readOnly = true)
    public void execute() {
        User user = userFacade.getCurrentUser();

        dalgonaRepository.save(new Dalgona(user));
    }
}
