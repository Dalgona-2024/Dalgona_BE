package com.example.signup_login.domain.user.service;

import com.example.signup_login.domain.user.entity.repository.DalgonaRepository;
import com.example.signup_login.domain.user.presentation.dto.response.QueryDalgonaListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryDalgonaService {
    private final DalgonaRepository dalgonaRepository;
    @Transactional(readOnly = true)
    public QueryDalgonaListResponse execute() {
        return new QueryDalgonaListResponse(
                dalgonaRepository.findAll().stream()
                        .map(dalgona -> new QueryDalgonaListResponse.DalgonaResponse(dalgona.getId(), dalgona.getDalContent()))
                        .toList()
        );
    }
}
