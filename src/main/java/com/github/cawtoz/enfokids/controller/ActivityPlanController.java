package com.github.cawtoz.enfokids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cawtoz.enfokids.dto.request.ActivityPlanRequest;
import com.github.cawtoz.enfokids.dto.response.ActivityPlanResponse;
import com.github.cawtoz.enfokids.generic.GenericController;
import com.github.cawtoz.enfokids.service.ActivityPlanService;

@RestController
@RequestMapping("/api/activity-plans")
public class ActivityPlanController extends GenericController<Long, ActivityPlanRequest, ActivityPlanResponse, ActivityPlanService> {
    
}