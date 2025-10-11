package com.github.cawtoz.enfokids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cawtoz.enfokids.dto.request.CaregiverChildRequest;
import com.github.cawtoz.enfokids.dto.response.CaregiverChildResponse;
import com.github.cawtoz.enfokids.generic.GenericController;
import com.github.cawtoz.enfokids.service.CaregiverChildService;

@RestController
@RequestMapping("/api/caregiver-children")
public class CaregiverChildController extends GenericController<Long, CaregiverChildRequest, CaregiverChildResponse, CaregiverChildService> {
    
}