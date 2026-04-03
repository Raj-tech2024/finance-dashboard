package com.finance.financedashboard.dto;

import com.finance.financedashboard.entity.RecordType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class FinancialRecordResponseDTO {
    private Long id;
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String description;
    private String userName;
}
