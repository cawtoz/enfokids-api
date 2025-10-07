package com.github.cawtoz.enfokids.repository;

import com.github.cawtoz.enfokids.model.activity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
