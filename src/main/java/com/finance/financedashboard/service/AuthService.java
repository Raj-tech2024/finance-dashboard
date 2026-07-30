package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.*;

public interface AuthService {

    AuthResponseDTO login(AuthRequestDTO request);

    UserResponseDto register(RegisterRequestDto request);}