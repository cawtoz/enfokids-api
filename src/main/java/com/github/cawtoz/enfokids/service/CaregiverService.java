package com.github.cawtoz.enfokids.service;

import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Caregiver;
import com.github.cawtoz.enfokids.repository.RoleRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaregiverService extends GenericService<Caregiver, Long> {

    @Autowired
    protected RoleRepository repository;

    @Override
    public Caregiver save(Caregiver caregiver) {
        repository.findByName(RoleEnum.CAREGIVER)
            .ifPresent(role -> caregiver.setRoles(Set.of(role)));
        return super.save(caregiver);
    }

}