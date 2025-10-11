package com.github.cawtoz.enfokids.dto.request;

import lombok.Data;

@Data
public class CaregiverRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
