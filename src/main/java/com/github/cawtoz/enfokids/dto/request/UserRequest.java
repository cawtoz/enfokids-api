package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Long> roleIds;
}
