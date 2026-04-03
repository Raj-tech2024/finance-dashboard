package com.finance.financedashboard.controller;

import com.finance.financedashboard.dto.FinancialRecordRequestDTO;
import com.finance.financedashboard.dto.FinancialRecordResponseDTO;
import com.finance.financedashboard.entity.FinancialRecord;
import com.finance.financedashboard.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/record")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService recordService;

     @PostMapping
    public FinancialRecordResponseDTO create(@RequestBody FinancialRecordRequestDTO request) {
        return recordService.createRecord(request);
    }

    @GetMapping("/records")
    public Page<FinancialRecord> getAllRecords(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return recordService.getAllRecords(page, size);
    }

    @GetMapping("/type")
    public List<FinancialRecordResponseDTO> getByType(@RequestParam String type) {
        return recordService.getByType(type);
    }

    @GetMapping("/category")
    public List<FinancialRecordResponseDTO> getByCategory(@RequestParam String category) {
        return recordService.getByCategory(category);
    }

    @GetMapping("/date")
    public List<FinancialRecordResponseDTO> getByDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return recordService.getByDateRange(start, end);
    }
}
