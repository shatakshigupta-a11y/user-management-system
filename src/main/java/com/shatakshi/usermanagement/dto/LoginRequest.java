package com.shatakshi.usermanagement.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}