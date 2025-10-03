package com.github.cawtoz.enfokids.model.user.types;

import com.github.cawtoz.enfokids.model.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "therapists")
public class Therapist extends User {

    @Column(length = 30, nullable = false)
    private String speciality;
    
}
