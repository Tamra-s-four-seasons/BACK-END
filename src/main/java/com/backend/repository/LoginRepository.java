package com.backend.repository;

import com.backend.dto.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LoginRepository {

    private final JdbcTemplate jdbcTemplate;

    public String login(LoginRequest request) {

        // 2) UPSERT 실행
        String sql = """
            select nickname from users where user_id=? and password=?;
            """;

        return jdbcTemplate.queryForObject(
                sql,
                String.class,
                request.getId(),
                request.getPassword()
        );
    }

}
