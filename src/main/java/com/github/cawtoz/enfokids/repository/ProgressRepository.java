package com.github.cawtoz.enfokids.repository;

import org.springframework.stereotype.Repository;
import com.github.cawtoz.enfokids.model.activity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
