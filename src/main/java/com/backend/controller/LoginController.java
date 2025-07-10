package com.backend.controller;

import com.backend.dto.request.LoginRequest;
import com.backend.repository.UserRepository;
import com.backend.service.JwtService;
import com.backend.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

//    private final JwtService jwtService;
//    public static final Set<String> loginInfo = new HashSet<>();
//    private final WebClient web = WebClient.builder().build();
//    private final UserRepository userRepository;
//
//    @Value("${kakao.rest-key}") String restKey;
//    @Value("${kakao.redirect}") String redirect;
    private final LoginService loginService;


//    @Operation(
//            summary = "카카오 로그인 API",
//            description = "jwtToken 반환"
//    )
//    @GetMapping("/login/kakao/callback")
//    public Mono<String> kakao(@RequestParam String code) {
//
//        // 1) access_token 요청
//        return web.post()
//                .uri("https://kauth.kakao.com/oauth/token")
//                .body(BodyInserters.fromFormData("grant_type", "authorization_code")
//                        .with("client_id", restKey)
//                        .with("redirect_uri", redirect)
//                        .with("code", code))
//                .retrieve()
//                .bodyToMono(Map.class)
//                .flatMap(tok -> {
//                    String access = (String) tok.get("access_token");
//                    log.info("access : {}", access);
//                    // 2) 사용자 정보 호출
//                    return web.get()
//                            .uri("https://kapi.kakao.com/v2/user/me")
//                            .header(HttpHeaders.AUTHORIZATION, "Bearer " + access)
//                            .retrieve()
//                            .bodyToMono(Map.class);
//                })
//                .map(user -> {
//                    log.info("user : {}", user);
//                    Long id   = ((Number) user.get("id")).longValue();
//                    Map<?,?> account = (Map<?,?>) user.get("kakao_account");
//                    String email     = (String) account.get("email");          // 동의받은 경우에만 값 존재
//
//                    Map<?,?> props   = (Map<?,?>) user.get("properties");
//                    String nickname  = (String) props.get("nickname");         // 여기서 가져와야 함
//
//                    String jwtToken = jwtService.create(id, email);
//                    loginInfo.add(jwtToken);
//                    userRepository.addUser(id, email, nickname);
//                    // 3) JWT 발급 후 그대로 리턴
//                    return jwtToken;     // ex) "eyJhbGciOiJIUzI1NiIsInR5..."
//                });
//    }


    @Operation(
            summary = "로그인 API",
            description = "id 반환"
    )
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}