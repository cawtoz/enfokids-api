package com.github.cawtoz.enfokids.repository;

import com.github.cawtoz.enfokids.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
