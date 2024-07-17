package com.example.signup_login.domain.user.service;

import com.example.signup_login.domain.user.entity.User;
import com.example.signup_login.domain.user.entity.repository.DalRepository;
import com.example.signup_login.domain.user.entity.repository.DalgonaRepository;
import com.example.signup_login.domain.user.facade.UserFacade;
import com.example.signup_login.domain.user.presentation.dto.response.QueryDalgonaListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryDalgonaService {
    private final DalgonaRepository dalgonaRepository;
    private final UserFacade userFacade;
    @Transactional(readOnly = true)
    public QueryDalgonaListResponse execute() {
        User user = userFacade.getCurrentUser();

        return new QueryDalgonaListResponse(
                dalgonaRepository.findByUser(user).stream()
                        .map(dalgona -> new QueryDalgonaListResponse.DalgonaResponse(dalgona.getCategory(), dalgona.getDalContent()))
                        .toList()
        );
    }
}
