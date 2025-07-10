package com.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckPoint {
      private int checkpointId;
      private String name;
      private Double latitude;
      private Double longitude;
      private String address;
      private String description;
      private String imgUrls;
      private boolean isComplete;
}
