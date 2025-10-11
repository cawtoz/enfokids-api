package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

@Data
public class CaregiverChildRequest {
    private Long caregiverId;
    private Long childId;
    private String relationship;
}
