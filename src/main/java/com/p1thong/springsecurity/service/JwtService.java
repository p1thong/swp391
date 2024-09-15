package com.p1thong.springsecurity.service;

import com.p1thong.springsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JwtService {

    String extractUserName(String token);

//    String extractFullname(String token);
//
//    String extractRole(String token);

    String generateToken(User user);

    boolean isTokenValid(String token, UserDetails user);

    String generateRefreshToken(Map<String, Object> extraClaims, User user);
}
