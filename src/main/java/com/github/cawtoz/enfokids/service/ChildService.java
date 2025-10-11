package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.ChildRequest;
import com.github.cawtoz.enfokids.dto.response.ChildResponse;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.ChildMapper;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Child;

import java.util.Optional;

@Service
public class ChildService extends GenericService<Child, Long, ChildRequest, ChildResponse, ChildMapper> {

    @Autowired
    private RoleService roleService;

    @Override
    public ChildResponse create(ChildRequest request) {
        Child child = mapper.toEntity(request);
        roleService.assignRoleToUser(child, RoleEnum.CHILD);
        Child saved = repository.save(child);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<ChildResponse> update(Long id, ChildRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    Child updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }
    
}