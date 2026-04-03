package com.finance.financedashboard.dto;

import com.finance.financedashboard.entity.Role;
import com.finance.financedashboard.entity.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private Status status;
}
