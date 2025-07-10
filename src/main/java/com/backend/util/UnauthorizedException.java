package com.backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 401 Unauthorized 응답이 필요할 때 던지는 예외.
 * 컨트롤러·필터 어디서든 throw 하면 스프링이 자동으로 401로 변환해 준다.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("인증이 필요합니다.");
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
