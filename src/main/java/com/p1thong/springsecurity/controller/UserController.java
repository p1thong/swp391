package com.p1thong.springsecurity.controller;

import com.p1thong.springsecurity.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final JwtService jwtService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello User");
    }
//    @GetMapping("/profile")
//    public ResponseEntity<Map<String, Object>> getProfile(HttpServletRequest request) {
//        String token = request.getHeader("Authorization").substring(7);
//
//        // Giải mã token và lấy thông tin người dùng
//        String email = jwtService.extractUserName(token);
//        String fullname = jwtService.extractFullname(token);
//        String role = jwtService.extractRole(token);
//
//        // Tạo phản hồi chứa thông tin người dùng
//        Map<String, Object> response = new HashMap<>();
//        response.put("email", email);
//        response.put("fullname", fullname);
//        response.put("role", role);
//
//        return ResponseEntity.ok(response);
//    }
}
