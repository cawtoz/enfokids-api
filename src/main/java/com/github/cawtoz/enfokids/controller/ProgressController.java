package com.github.cawtoz.enfokids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cawtoz.enfokids.dto.request.ProgressRequest;
import com.github.cawtoz.enfokids.dto.response.ProgressResponse;
import com.github.cawtoz.enfokids.generic.GenericController;
import com.github.cawtoz.enfokids.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
public class ProgressController extends GenericController<Long, ProgressRequest, ProgressResponse, ProgressService> {
    
}