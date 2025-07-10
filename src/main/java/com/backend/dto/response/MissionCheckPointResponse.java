package com.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissionCheckPointResponse {
    private String checkpointId;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String description;
    private String isComplete;
}
