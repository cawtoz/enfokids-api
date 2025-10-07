package com.github.cawtoz.enfokids.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cawtoz.enfokids.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
