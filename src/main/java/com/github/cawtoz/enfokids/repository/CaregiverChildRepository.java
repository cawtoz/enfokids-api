package com.github.cawtoz.enfokids.repository;

import org.springframework.stereotype.Repository;
import com.github.cawtoz.enfokids.model.relation.CaregiverChild;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CaregiverChildRepository extends JpaRepository<CaregiverChild, Long> {
}
