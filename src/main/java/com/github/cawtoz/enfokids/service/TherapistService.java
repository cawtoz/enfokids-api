package com.github.cawtoz.enfokids.service;

import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.model.role.RoleEnum;
import com.github.cawtoz.enfokids.model.user.types.Therapist;
import com.github.cawtoz.enfokids.repository.RoleRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TherapistService extends GenericService<Therapist, Long> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Therapist save(Therapist therapist) {
        roleRepository.findByName(RoleEnum.THERAPIST)
            .ifPresent(role -> therapist.setRoles(Set.of(role)));
        return super.save(therapist);
    }

}