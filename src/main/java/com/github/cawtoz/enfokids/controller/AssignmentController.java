package com.github.cawtoz.enfokids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cawtoz.enfokids.dto.request.AssignmentRequest;
import com.github.cawtoz.enfokids.dto.request.AssignmentUpdateRequest;
import com.github.cawtoz.enfokids.dto.response.AssignmentResponse;
import com.github.cawtoz.enfokids.generic.GenericController;
import com.github.cawtoz.enfokids.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController extends GenericController<Long, AssignmentRequest, AssignmentUpdateRequest, AssignmentResponse, AssignmentService> {
    
}