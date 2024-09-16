package com.p1thong.springsecurity.dto;

import com.p1thong.springsecurity.entity.Role;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String fullname;
    private String email;
    private Role role;
    private String token;
    private String refreshToken;
}
