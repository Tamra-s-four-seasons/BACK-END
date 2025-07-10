package com.backend.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {
    private String id;
    private String password;
}
