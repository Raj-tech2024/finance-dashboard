package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.UserRequestDto;
import com.finance.financedashboard.dto.UserResponseDto;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto Request);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto updateUser(Long id, UserRequestDto request);
    void deleteUser(Long id);
}
