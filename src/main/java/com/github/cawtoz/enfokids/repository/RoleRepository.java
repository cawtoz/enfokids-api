package com.github.cawtoz.enfokids.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.cawtoz.enfokids.model.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
