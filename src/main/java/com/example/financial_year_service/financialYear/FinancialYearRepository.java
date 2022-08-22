package com.example.financial_year_service.financialYear;


import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FinancialYearRepository extends R2dbcRepository<FinancialYear, Integer> {
}
