package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.DashboardResponseDTO;
import com.finance.financedashboard.entity.FinancialRecord;
import com.finance.financedashboard.entity.RecordType;
import com.finance.financedashboard.repository.FinanceRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private final FinanceRecordRepository recordRepository;

    @Override
    public DashboardResponseDTO getSummary() {

        List<FinancialRecord> records = recordRepository.findAll();

        double totalIncome = 0;
        double totalExpense = 0;

        Map<String, Double> categoryMap = new HashMap<>();

        for (FinancialRecord record : records) {

            if (record.getType() == RecordType.INCOME) {
                totalIncome += record.getAmount();
            } else {
                totalExpense += record.getAmount();
            }

            // category-wise
            categoryMap.put(
                    record.getCategory(),
                    categoryMap.getOrDefault(record.getCategory(), 0.0) + record.getAmount()
            );
        }

        return DashboardResponseDTO.builder()
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .netBalance(totalIncome - totalExpense)
                .categoryWise(categoryMap)
                .build();
    }
}
