package com.github.cawtoz.enfokids.model.user.types;

import java.util.HashSet;
import java.util.Set;

import com.github.cawtoz.enfokids.model.relation.CaregiverChild;
import com.github.cawtoz.enfokids.model.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "children")
public class Child extends User {

    @OneToMany(mappedBy = "child")
    private Set<CaregiverChild> caregiverChildren = new HashSet<>();
    
}
