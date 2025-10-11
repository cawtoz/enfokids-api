package com.github.cawtoz.enfokids.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cawtoz.enfokids.dto.request.UserRequest;
import com.github.cawtoz.enfokids.dto.response.UserResponse;
import com.github.cawtoz.enfokids.generic.GenericService;
import com.github.cawtoz.enfokids.mapper.UserMapper;
import com.github.cawtoz.enfokids.model.role.Role;
import com.github.cawtoz.enfokids.model.user.User;
import com.github.cawtoz.enfokids.repository.RoleRepository;
import com.github.cawtoz.enfokids.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService extends GenericService<User, Long, UserRequest, UserResponse, UserMapper> {

    @Autowired
    protected UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public Optional<UserResponse> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toResponse);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User user = mapper.toEntity(request);
        setRolesFromIds(user, request.getRoleIds());
        User saved = repository.save(user);
        return mapper.toResponse(saved);
    }
    
    @Override
    public Optional<UserResponse> update(Long id, UserRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntityFromRequest(request, existing);
                    setRolesFromIds(existing, request.getRoleIds());
                    User updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
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