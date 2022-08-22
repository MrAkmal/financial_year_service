package com.example.financial_year_service.financialYear;


import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface FinancialYearRepository extends R2dbcRepository<FinancialYear, Integer> {


    @Transactional
    @Modifying
    @Query("update financial_year  set year = :#{#dto.financialYear}, is_default = :#{#dto.isDefault} where id = :#{#dto.id} ")
    Mono<FinancialYear> update(FinancialYearUpdateDTO dto);

}
