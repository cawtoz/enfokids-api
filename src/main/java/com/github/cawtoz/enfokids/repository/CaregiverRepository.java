package com.github.cawtoz.enfokids.repository;

import com.github.cawtoz.enfokids.model.user.types.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {
}
