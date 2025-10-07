package com.github.cawtoz.enfokids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cawtoz.enfokids.model.role.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
