package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.AssignmentRequest;
import com.github.cawtoz.enfokids.dto.response.AssignmentResponse;
import com.github.cawtoz.enfokids.exception.ResourceNotFoundException;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.AssignmentMapper;
import com.github.cawtoz.enfokids.model.activity.Assignment;
import com.github.cawtoz.enfokids.repository.ActivityRepository;
import com.github.cawtoz.enfokids.repository.ChildRepository;
import com.github.cawtoz.enfokids.repository.TherapistRepository;

import java.util.Optional;

@Service
public class AssignmentService extends GenericService<Assignment, Long, AssignmentRequest, AssignmentResponse, AssignmentMapper> {

    @Autowired
    private TherapistRepository therapistRepository;
    
    @Autowired
    private ChildRepository childRepository;
    
    @Autowired
    private ActivityRepository activityRepository;
    
    @Override
    public AssignmentResponse create(AssignmentRequest request) {
        Assignment assignment = mapper.toEntity(request);
        setRelationsFromIds(assignment, request.getTherapistId(), request.getChildId(), request.getActivityId());
        Assignment saved = repository.save(assignment);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<AssignmentResponse> update(Long id, AssignmentRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    setRelationsFromIds(existing, request.getTherapistId(), request.getChildId(), request.getActivityId());
                    Assignment updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }
    
    private void setRelationsFromIds(Assignment assignment, Long therapistId, Long childId, Long activityId) {
        if (therapistId != null) {
            assignment.setTherapist(
                therapistRepository.findById(therapistId)
                    .orElseThrow(() -> new ResourceNotFoundException("Terapeuta", "id", therapistId))
            );
        }
        if (childId != null) {
            assignment.setChild(
                childRepository.findById(childId)
                    .orElseThrow(() -> new ResourceNotFoundException("Niño", "id", childId))
            );
        }
        if (activityId != null) {
            assignment.setActivity(
                activityRepository.findById(activityId)
                    .orElseThrow(() -> new ResourceNotFoundException("Actividad", "id", activityId))
            );
        }
    }
    
}