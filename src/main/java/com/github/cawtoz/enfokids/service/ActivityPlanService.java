package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.ActivityPlanRequest;
import com.github.cawtoz.enfokids.dto.response.ActivityPlanResponse;
import com.github.cawtoz.enfokids.exception.ResourceNotFoundException;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.ActivityPlanMapper;
import com.github.cawtoz.enfokids.model.activity.ActivityPlan;
import com.github.cawtoz.enfokids.repository.TherapistRepository;

import java.util.Optional;

@Service
public class ActivityPlanService extends GenericService<ActivityPlan, Long, ActivityPlanRequest, ActivityPlanResponse, ActivityPlanMapper> {
    
    @Autowired
    private TherapistRepository therapistRepository;
    
    @Override
    public ActivityPlanResponse create(ActivityPlanRequest request) {
        ActivityPlan activityPlan = mapper.toEntity(request);
        setTherapistFromId(activityPlan, request.getTherapistId());
        ActivityPlan saved = repository.save(activityPlan);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<ActivityPlanResponse> update(Long id, ActivityPlanRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    setTherapistFromId(existing, request.getTherapistId());
                    ActivityPlan updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }
    
    private void setTherapistFromId(ActivityPlan activityPlan, Long therapistId) {
        if (therapistId != null) {
            activityPlan.setTherapist(
                therapistRepository.findById(therapistId)
                    .orElseThrow(() -> new ResourceNotFoundException("Terapeuta", "id", therapistId))
            );
        }
    }
    
}