package com.finance.financedashboard.repository;

import com.finance.financedashboard.entity.FinancialRecord;
import com.finance.financedashboard.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinanceRecordRepository extends JpaRepository<FinancialRecord,Long> {
    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}
