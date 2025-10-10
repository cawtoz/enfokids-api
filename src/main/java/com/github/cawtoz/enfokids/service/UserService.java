package com.github.cawtoz.enfokids.service;

import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.model.role.Role;
import com.github.cawtoz.enfokids.model.user.User;
import com.github.cawtoz.enfokids.repository.RoleRepository;
import com.github.cawtoz.enfokids.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService extends GenericService<User, Long> {

    @Autowired
    protected UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void setRolesFromIds(User user, Set<Long> roleIds) {
        if (roleIds != null && !roleIds.isEmpty()) {
            Set<Role> roles = new HashSet<>();
            for (Long roleId : roleIds) {
                roleRepository.findById(roleId).ifPresent(roles::add);
            }
            user.setRoles(roles);
        }
    }
    
}