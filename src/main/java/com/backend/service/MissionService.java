package com.backend.service;

import com.backend.dto.request.CheckPointRequest;
import com.backend.dto.request.InProgressCreateRequest;
import com.backend.dto.response.MissionCheckPointResponse;
import com.backend.dto.response.InProgressMissionResponse;
import com.backend.dto.response.MissionCompleteResponse;
import com.backend.dto.response.RouteResponse;
import com.backend.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;

    public List<InProgressMissionResponse> findInProgressMission(String loginId) {
        List<InProgressMissionResponse> response = missionRepository.findInProgressMission(loginId);
        return missionRepository.getCheckPoints(loginId, response);
    }

    public int createInProgressMission(InProgressCreateRequest request) {
        return missionRepository.createInProgressMission(request);
    }

    public List<RouteResponse> findRoute(String userId) {
        return missionRepository.findRoute(userId);
    }

    public List<MissionCheckPointResponse> getInProgressMission(String userId, Long missionId) {
        return missionRepository.getInProgressMission(userId, missionId);
    }

    public int createCheckPoint(CheckPointRequest request) {
        return missionRepository.createCheckPoint(request);
    }

    public List<MissionCompleteResponse> findInProgressMissionComplete(String userId) {
        return missionRepository.findInProgressMissionComplete(userId);
    }





}
