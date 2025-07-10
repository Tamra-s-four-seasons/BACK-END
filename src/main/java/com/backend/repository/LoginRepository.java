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
            select user_id from users where user_id=? and password=?;
            """;
        System.out.println(request.getId() + " " +request.getPassword());
        return jdbcTemplate.queryForObject(
                sql,
                String.class,
                request.getId(),
                request.getPassword()
        );
    }

}
