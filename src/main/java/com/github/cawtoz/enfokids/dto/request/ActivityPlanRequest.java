package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

@Data
public class ActivityPlanRequest {
    private Long therapistId;
    private String title;
    private String description;
}
