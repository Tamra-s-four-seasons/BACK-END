package com.backend.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * 카카오 /v2/user/me 응답(Map) 하나를 받아
     * - 새 사용자면 INSERT
     * - 기존 사용자면 UPDATE
     * 를 한 번에 처리한다.
     */
    public void addUser(Long id, String email, String nickname) {

        // 2) UPSERT 실행
        String sql = """
            INSERT INTO kakao_user (kakao_id, email, nickname, profile_image)
            VALUES (?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
                email         = VALUES(email),
                nickname      = VALUES(nickname),
                profile_image = VALUES(profile_image),
                updated_at    = CURRENT_TIMESTAMP
            """;

        jdbcTemplate.update(sql, id, email, nickname);

    }
}
