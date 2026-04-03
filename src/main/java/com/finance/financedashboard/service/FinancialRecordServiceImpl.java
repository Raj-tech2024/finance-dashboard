package com.finance.financedashboard.service;

import com.finance.financedashboard.dto.FinancialRecordRequestDTO;
import com.finance.financedashboard.dto.FinancialRecordResponseDTO;
import com.finance.financedashboard.entity.FinancialRecord;
import com.finance.financedashboard.entity.RecordType;
import com.finance.financedashboard.entity.User;
import com.finance.financedashboard.repository.FinanceRecordRepository;
import com.finance.financedashboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinancialRecordServiceImpl implements FinancialRecordService {

    private final FinanceRecordRepository recordRepository;
    private final UserRepository userRepository;

    @Override
    public FinancialRecordResponseDTO createRecord(FinancialRecordRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FinancialRecord record = FinancialRecord.builder()
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .date(request.getDate())
                .description(request.getDescription())
                .user(user)
                .build();

        recordRepository.save(record);

        return mapToDTO(record);
    }

    @Override
    public Page<FinancialRecord> getAllRecords(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return recordRepository.findAll(pageable);
    }

    @Override
    public List<FinancialRecordResponseDTO> getByType(String type) {
        return recordRepository.findByType(RecordType.valueOf(type))
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FinancialRecordResponseDTO> getByCategory(String category) {
        return recordRepository.findByCategory(category)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FinancialRecordResponseDTO> getByDateRange(LocalDate start, LocalDate end) {
        return recordRepository.findByDateBetween(start, end)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private FinancialRecordResponseDTO mapToDTO(FinancialRecord record) {
        return FinancialRecordResponseDTO.builder()
                .id(record.getId())
                .amount(record.getAmount())
                .type(record.getType())
                .category(record.getCategory())
                .date(record.getDate())
                .description(record.getDescription())
                .userName(record.getUser().getName())
                .build();
    }
}
