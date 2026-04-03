package com.finance.financedashboard.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
@Builder
public class DashboardResponseDTO {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;
    private Map<String, Double> categoryWise;
}
