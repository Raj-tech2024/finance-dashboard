package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.AuthRequestDTO;
import com.finance.financedashboard.dto.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(AuthRequestDTO request);
}
