package com.github.cawtoz.enfokids.repository;

import org.springframework.stereotype.Repository;
import com.github.cawtoz.enfokids.model.activity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}
