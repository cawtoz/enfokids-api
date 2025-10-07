package com.github.cawtoz.enfokids.repository;

import com.github.cawtoz.enfokids.model.user.types.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapistRepository extends JpaRepository<Therapist, Long> {
}
