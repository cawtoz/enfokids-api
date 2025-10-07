package com.github.cawtoz.enfokids.repository;

import com.github.cawtoz.enfokids.model.user.types.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
