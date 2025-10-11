package com.github.cawtoz.enfokids.dto.request;

import com.github.cawtoz.enfokids.model.activity.enums.AssignmentStatusEnum;
import com.github.cawtoz.enfokids.model.activity.enums.FrequencyUnitEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AssignmentRequest {
    private Long therapistId;
    private Long childId;
    private Long activityId;
    private FrequencyUnitEnum frequencyUnit;
    private Integer frequencyCount;
    private Integer repetitions;
    private Integer estimatedDuration;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private AssignmentStatusEnum status;
    private String notes;
}
