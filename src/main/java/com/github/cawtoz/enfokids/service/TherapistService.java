package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.TherapistRequest;
import com.github.cawtoz.enfokids.dto.response.TherapistResponse;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.TherapistMapper;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Therapist;

import java.util.Optional;

@Service
public class TherapistService extends GenericService<Therapist, Long, TherapistRequest, TherapistResponse, TherapistMapper> {

    @Autowired
    private RoleService roleService;

    @Override
    public TherapistResponse create(TherapistRequest request) {
        Therapist therapist = mapper.toEntity(request);
        roleService.assignRoleToUser(therapist, RoleEnum.THERAPIST);
        Therapist saved = repository.save(therapist);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<TherapistResponse> update(Long id, TherapistRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    Therapist updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }

}