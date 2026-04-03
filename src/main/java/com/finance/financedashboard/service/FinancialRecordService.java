package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.FinancialRecordRequestDTO;
import com.finance.financedashboard.dto.FinancialRecordResponseDTO;
import com.finance.financedashboard.entity.FinancialRecord;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordService {
    FinancialRecordResponseDTO createRecord(FinancialRecordRequestDTO request);

    public Page<FinancialRecord> getAllRecords(int page, int size);

    List<FinancialRecordResponseDTO> getByType(String type);

    List<FinancialRecordResponseDTO> getByCategory(String category);

    List<FinancialRecordResponseDTO> getByDateRange(LocalDate start, LocalDate end);
}
