package com.backend.controller;

import com.backend.dto.request.CheckPointRequest;
import com.backend.dto.request.InProgressCreateRequest;
import com.backend.dto.response.InProgressMissionResponse;
import com.backend.dto.response.MissionCheckPointResponse;
import com.backend.dto.response.MissionCompleteResponse;
import com.backend.dto.response.RouteResponse;
import com.backend.service.JwtService;
import com.backend.service.MissionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;
    private final JwtService jwtService;

    @Operation(summary = "진행중인 미션 리스트 확인 요청")
    @GetMapping("/in-progress")
    public List<InProgressMissionResponse> findInProgressMission(
            @RequestParam String loginId
    ) {
        return missionService.findInProgressMission(loginId);
    }

    @Operation(summary = "미션 진행 생성!")
    @PostMapping("/in-progress")
    public int createInProgressMission(
            @RequestBody InProgressCreateRequest request
    ) {
        return missionService.createInProgressMission(request);
    }

    @Operation(summary = "모든 경로에 대한 상태 요청 (완료 여부 포함)")
    @GetMapping("/route/{userId}")
    public List<RouteResponse> findRoute(
            @PathVariable String userId
    ) {
        return missionService.findRoute(userId);
    }

    @Operation(summary = "진행중인 경로에 대한 상세 요청 (체크포인트 완료 여부 포함 요청) 사용 안함")
    @GetMapping("/in-progress/{missionId}")
    public List<MissionCheckPointResponse> getInProgress(
            @RequestParam String loginId,
            @PathVariable Long missionId
    ) {
        return missionService.getInProgressMission(loginId, missionId);
    }

    @Operation(summary = "체크 포인트 완료 요청")
    @PostMapping("/check-point")
    public int createCheckPoint(
            @RequestBody CheckPointRequest request
    ) {
        return missionService.createCheckPoint(request);
    }

//      if (loginUtil.checkLogin(authorization)) {
//            throw new UnauthorizedException("로그인된 사용자가 아닙니다.");
//        }
//        Long userId = jwtService.extractUserId(authorization);
}
