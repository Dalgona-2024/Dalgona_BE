package com.example.signup_login.domain.user.presentation;

import com.example.signup_login.domain.user.presentation.dto.response.QueryDalgonaListResponse;
import com.example.signup_login.domain.user.service.GetDalgonaService;
import com.example.signup_login.domain.user.service.QueryDalgonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final GetDalgonaService getDalgonaService;
    private final QueryDalgonaService queryDalgonaService;
    @PostMapping("/dalgona")
    public void getDalgona() {
        getDalgonaService.execute();
    }

    @GetMapping("/dalgona/all")
    public QueryDalgonaListResponse getAllDalgona() {
        return queryDalgonaService.execute();
    }
}
