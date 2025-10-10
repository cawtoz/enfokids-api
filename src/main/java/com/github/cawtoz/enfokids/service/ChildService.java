package com.github.cawtoz.enfokids.service;

import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Child;
import com.github.cawtoz.enfokids.repository.RoleRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService extends GenericService<Child, Long> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Child save(Child child) {
        roleRepository.findByName(RoleEnum.CHILD)
            .ifPresent(role -> child.setRoles(Set.of(role)));
        return super.save(child);
    }
    
}