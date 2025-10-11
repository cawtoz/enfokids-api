package com.github.cawtoz.enfokids.dto.request;

import com.github.cawtoz.enfokids.model.activity.enums.FrequencyUnitEnum;
import lombok.Data;

@Data
public class PlanDetailRequest {
    private Long planId;
    private Long activityId;
    private FrequencyUnitEnum frequencyUnit;
    private Integer frequencyCount;
    private Integer repetitions;
    private Integer estimatedDuration;
}
