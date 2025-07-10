package com.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponse {
    private Integer routeId;
    private String routeName;
    private Integer difficulty;
    private String approxLocation;
    private String tags;
    private Double expectedDistance;
    private String routeDescription;
    private Boolean isComplete;
}
