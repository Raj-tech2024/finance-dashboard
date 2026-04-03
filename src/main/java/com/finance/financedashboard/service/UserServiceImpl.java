package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.UserRequestDto;
import com.finance.financedashboard.dto.UserResponseDto;
import com.finance.financedashboard.entity.Status;
import com.finance.financedashboard.entity.User;
import com.finance.financedashboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserRequestDto Request) {
        User user =User.builder()
                .name(Request.getName())
                .email(Request.getEmail())
                .password(passwordEncoder.encode(Request.getPassword()))
                .role(Request.getRole())
                .status(Status.ACTIVE)
                .build();
        userRepository.save(user);
        return mapToDTO(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public UserResponseDto getUserById(Long id) {
        User user = (User) userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDTO(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto request) {

        User user = (User) userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        userRepository.save(user);

        return mapToDTO(user);
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setStatus(Status.INACTIVE); // soft delete
        userRepository.save(user);
    }

    private UserResponseDto mapToDTO(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus())
                .build();
    }
}
