package com.finance.financedashboard.controller;

import com.finance.financedashboard.dto.*;
import com.finance.financedashboard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 🔐 LOGIN API
    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        return authService.login(request);
    }
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody RegisterRequestDto request) {
        return authService.register(request);
    }
}

