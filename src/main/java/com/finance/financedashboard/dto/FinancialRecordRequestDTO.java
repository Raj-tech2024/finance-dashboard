package com.finance.financedashboard.dto;

import com.finance.financedashboard.entity.RecordType;
import lombok.Data;

import java.time.LocalDate;
@Data

public class FinancialRecordRequestDTO {
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String description;
    private Long userId;
}
