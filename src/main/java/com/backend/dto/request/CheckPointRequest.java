package com.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckPointRequest {
    private String userId;
    private String missionId;
    private String checkpointId;
}
