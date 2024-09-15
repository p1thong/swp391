package com.p1thong.springsecurity.service.impl;

import com.p1thong.springsecurity.dto.JwtAuthenticationResponse;
import com.p1thong.springsecurity.dto.RefreshTokenRequest;
import com.p1thong.springsecurity.dto.SigninRequest;
import com.p1thong.springsecurity.dto.SignupRequest;
import com.p1thong.springsecurity.entity.Role;
import com.p1thong.springsecurity.entity.User;
import com.p1thong.springsecurity.repository.UserRepository;
import com.p1thong.springsecurity.service.AuthenticationService;
import com.p1thong.springsecurity.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User signup(SignupRequest signupRequest) {
        User user = new User();

        user.setFullname(signupRequest.getFullname());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getEmail(), signinRequest.getPassword()
        ));
        var user = userRepository.findByEmail(signinRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setFullname(user.getFullname());
        jwtAuthenticationResponse.setEmail(user.getEmail());
        jwtAuthenticationResponse.setRole(user.getRole());
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        return jwtAuthenticationResponse;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            var jwt = jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }
}
