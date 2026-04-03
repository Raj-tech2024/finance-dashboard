package com.finance.financedashboard.controller;

import com.finance.financedashboard.dto.DashboardResponseDTO;
import com.finance.financedashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;
    @PreAuthorize("ADMIN")
     @GetMapping("/summary")
    public DashboardResponseDTO getSummary() {
        return dashboardService.getSummary();
    }
}
