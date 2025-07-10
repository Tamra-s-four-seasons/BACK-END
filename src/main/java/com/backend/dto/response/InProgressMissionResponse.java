package com.backend.dto.response;

import com.backend.dto.CheckPoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InProgressMissionResponse {
    private Integer missionId;
    private Integer routeId;
    private String userId;
    private String routeDescription;
    private String routeName;
    private Boolean isComplete;
    private List<CheckPoint> checkPoint;
}
