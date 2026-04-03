package com.finance.financedashboard;

import com.finance.financedashboard.entity.FinancialRecord;
import com.finance.financedashboard.repository.FinanceRecordRepository;
import com.finance.financedashboard.service.FinancialRecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public  class FinancialRecordServiceTest {

        @Mock
        private FinanceRecordRepository recordRepository;

        @InjectMocks
        private FinancialRecordServiceImpl recordService;
        @Test
        void testGetAllRecords() {

            // Arrange
            FinancialRecord record = new FinancialRecord();
            record.setId(1L);
            record.setAmount(1000.0);

            List<FinancialRecord> list = List.of(record);

            Pageable pageable = PageRequest.of(0, 5);
            Page<FinancialRecord> page = new PageImpl<>(list);

            when(recordRepository.findAll(pageable)).thenReturn(page);

            // Act
            Page<FinancialRecord> result = recordService.getAllRecords(0, 5);

            // Assert
            assertNotNull(result);
            assertEquals(1, result.getTotalElements());
            verify(recordRepository, times(1)).findAll(pageable);
        }
    }
