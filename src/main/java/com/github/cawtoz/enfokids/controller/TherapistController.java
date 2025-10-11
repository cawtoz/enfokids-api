package com.github.cawtoz.enfokids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cawtoz.enfokids.dto.request.TherapistRequest;
import com.github.cawtoz.enfokids.dto.response.TherapistResponse;
import com.github.cawtoz.enfokids.generic.GenericController;
import com.github.cawtoz.enfokids.service.TherapistService;

@RestController
@RequestMapping("/api/therapists")
public class TherapistController extends GenericController<Long, TherapistRequest, TherapistResponse, TherapistService> {
    
}