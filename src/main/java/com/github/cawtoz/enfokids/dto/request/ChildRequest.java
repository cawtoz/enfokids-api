package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

@Data
public class ChildRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
