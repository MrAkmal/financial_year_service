package com.example.financial_year_service.financialYear;

import com.example.financial_year_service.financialYear.dto.FinancialYearCreateDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialYearService {

    private final FinancialYearRepository repository;
    private final FinancialYearMapper mapper;

    @Autowired
    public FinancialYearService(FinancialYearRepository repository, FinancialYearMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Integer save(FinancialYearCreateDTO dto) {

        FinancialYear entity = mapper.fromCreateDTO(dto);

        FinancialYear financialYear = repository.save(entity);

        return financialYear.getId();

    }


    public Integer delete(int financialYear) {

        repository.deleteById(financialYear);

        return financialYear;
    }


    public Integer update(FinancialYearUpdateDTO dto) {

        Optional<FinancialYear> optional = repository.findById(dto.getId());

        if (optional.isEmpty()) throw new RuntimeException("FinancialYear not found by id - " + dto.getId());

        FinancialYear entity = mapper.fromUpdateDTO(dto);

        FinancialYear financialYear = repository.save(entity);

        return financialYear.getId();

    }


    public FinancialYearDTO get(int financialYearId) {

        Optional<FinancialYear> optional = repository.findById(financialYearId);

        if (optional.isEmpty()) throw new RuntimeException("FinancialYear not found by id - " + financialYearId);

        return mapper.toDTO(optional.get());
    }


    public List<FinancialYearDTO> getAll() {

        List<FinancialYear> financialYears = repository.findAll();

        if (financialYears.isEmpty()) throw new RuntimeException("No financial years");

        return mapper.toDTO(financialYears);
    }

}
