package com.github.cawtoz.enfokids.repository;

import org.springframework.stereotype.Repository;
import com.github.cawtoz.enfokids.model.user.types.Child;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
}
