package com.backend.service;

import com.backend.dto.request.LoginRequest;
import com.backend.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public String login(LoginRequest request) {
        return loginRepository.login(request);
    }
}
