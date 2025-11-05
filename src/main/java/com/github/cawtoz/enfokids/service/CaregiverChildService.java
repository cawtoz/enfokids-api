package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.CaregiverChildRequest;
import com.github.cawtoz.enfokids.dto.request.CaregiverChildUpdateRequest;
import com.github.cawtoz.enfokids.dto.response.CaregiverChildResponse;
import com.github.cawtoz.enfokids.exception.ResourceNotFoundException;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.CaregiverChildMapper;
import com.github.cawtoz.enfokids.model.relation.CaregiverChild;
import com.github.cawtoz.enfokids.repository.CaregiverRepository;
import com.github.cawtoz.enfokids.repository.ChildRepository;

import java.util.Optional;

@Service
public class CaregiverChildService extends GenericService<CaregiverChild, Long, CaregiverChildRequest, CaregiverChildUpdateRequest, CaregiverChildResponse, CaregiverChildMapper> {

    @Autowired
    private CaregiverRepository caregiverRepository;
    
    @Autowired
    private ChildRepository childRepository;
    
    @Override
    public CaregiverChildResponse create(CaregiverChildRequest request) {
        CaregiverChild caregiverChild = mapper.toEntity(request);
        setRelationsFromIds(caregiverChild, request.getCaregiverId(), request.getChildId());
        CaregiverChild saved = repository.save(caregiverChild);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<CaregiverChildResponse> update(Long id, CaregiverChildUpdateRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromUpdateRequest(request, existing);
                    setRelationsFromIds(existing, request.getCaregiverId(), request.getChildId());
                    CaregiverChild updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }
    
    private void setRelationsFromIds(CaregiverChild caregiverChild, Long caregiverId, Long childId) {
        if (caregiverId != null) {
            caregiverChild.setCaregiver(
                caregiverRepository.findById(caregiverId)
                    .orElseThrow(() -> new ResourceNotFoundException("Cuidador", "id", caregiverId))
            );
        }
        if (childId != null) {
            caregiverChild.setChild(
                childRepository.findById(childId)
                    .orElseThrow(() -> new ResourceNotFoundException("Niño", "id", childId))
            );
        }
    }
    
}