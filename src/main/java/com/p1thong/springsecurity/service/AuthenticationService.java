package com.p1thong.springsecurity.service;

import com.p1thong.springsecurity.dto.JwtAuthenticationResponse;
import com.p1thong.springsecurity.dto.RefreshTokenRequest;
import com.p1thong.springsecurity.dto.SigninRequest;
import com.p1thong.springsecurity.dto.SignupRequest;
import com.p1thong.springsecurity.entity.User;

public interface AuthenticationService {

    User signup(SignupRequest signupRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
