package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.AuthRequestDTO;
import com.finance.financedashboard.dto.AuthResponseDTO;
import com.finance.financedashboard.entity.User;
import com.finance.financedashboard.repository.UserRepository;
import com.finance.financedashboard.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDTO login(AuthRequestDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }
}
