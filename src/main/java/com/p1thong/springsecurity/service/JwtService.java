package com.p1thong.springsecurity.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.p1thong.springsecurity.entity.User;

public interface JwtService {

    String extractUserName(String token);

//    String extractFullname(String token);
//
//    String extractRole(String token);

    String generateToken(User user);

    boolean isTokenValid(String token, UserDetails user);

    String generateRefreshToken(Map<String, Object> extraClaims, User user);
}
