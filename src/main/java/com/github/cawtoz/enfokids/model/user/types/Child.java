package com.github.cawtoz.enfokids.model.user.types;

import com.github.cawtoz.enfokids.model.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "children")
public class Child extends User {
    
}
