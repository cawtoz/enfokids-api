package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProgressRequest {
    private Long assignmentId;
    private String notes;
    private LocalDateTime date;
    private Boolean completed;
}
