package com.github.cawtoz.enfokids.dto.request;

import com.github.cawtoz.enfokids.model.activity.enums.ActivityTypeEnum;
import lombok.Data;

@Data
public class ActivityRequest {
    private String title;
    private String description;
    private ActivityTypeEnum type;
    private String imageUrl;
    private String resourceUrl;
}
