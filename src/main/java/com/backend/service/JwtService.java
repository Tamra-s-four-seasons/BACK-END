package com.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secret}")         String secret;
    @Value("${jwt.expiry-seconds}") long expiry;

    public String create(Long userId, String email) {
        return JWT.create()
                .withSubject(userId.toString())
                .withClaim("email", email)
                .withExpiresAt(
                        Date.from(Instant.now().plusSeconds(expiry)))
                .sign(Algorithm.HMAC256(secret));
    }

    public Long extractUserId(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secret))   // ⬅️ 같은 secret
                .build()
                .verify(token);                      // 서명 + 만료 검사

        return Long.valueOf(jwt.getSubject());  // create() 때 넣어 둔 userId
    }
}

