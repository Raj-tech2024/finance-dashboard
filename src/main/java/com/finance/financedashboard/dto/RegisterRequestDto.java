package com.finance.financedashboard.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {

    private String name;

    private String email;

    private String password;
}