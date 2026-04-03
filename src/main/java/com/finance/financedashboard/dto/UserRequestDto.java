package com.finance.financedashboard.dto;

import com.finance.financedashboard.entity.Role;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String password;
    private String email;
    private Role role;

}
