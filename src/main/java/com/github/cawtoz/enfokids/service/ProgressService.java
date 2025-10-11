package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.ProgressRequest;
import com.github.cawtoz.enfokids.dto.response.ProgressResponse;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.ProgressMapper;
import com.github.cawtoz.enfokids.model.activity.Progress;
import com.github.cawtoz.enfokids.repository.AssignmentRepository;

import java.util.Optional;

@Service
public class ProgressService extends GenericService<Progress, Long, ProgressRequest, ProgressResponse, ProgressMapper> {
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    
    @Override
    public ProgressResponse create(ProgressRequest request) {
        Progress progress = mapper.toEntity(request);
        setAssignmentFromId(progress, request.getAssignmentId());
        Progress saved = repository.save(progress);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<ProgressResponse> update(Long id, ProgressRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    setAssignmentFromId(existing, request.getAssignmentId());
                    Progress updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }
    
    private void setAssignmentFromId(Progress progress, Long assignmentId) {
        if (assignmentId != null) assignmentRepository.findById(assignmentId).ifPresent(progress::setAssignment);
    }

}