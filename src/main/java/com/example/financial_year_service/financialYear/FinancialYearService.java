package com.example.financial_year_service.financialYear;

import com.example.financial_year_service.financialYear.dto.FinancialYearCreateDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
public class FinancialYearService {

    private final FinancialYearRepository repository;
    private final FinancialYearMapper mapper;

    @Autowired
    public FinancialYearService(FinancialYearRepository repository, FinancialYearMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Mono<FinancialYear> save(FinancialYearCreateDTO dto) {

        FinancialYear entity = mapper.fromCreateDTO(dto);

        return repository.save(entity);

    }


    public Mono<Void> delete(int financialYear) {

        return repository.deleteById(financialYear);
    }


    public Mono<FinancialYear> update(FinancialYearUpdateDTO dto) {

        Mono<FinancialYear> financialYearMono = repository.findById(dto.getId());

        FinancialYear block = financialYearMono.block();
        if (Objects.isNull(block)) throw new RuntimeException("Not Found");

        FinancialYear entity = mapper.fromUpdateDTO(dto);

        return repository.save(entity);

    }


    public Mono<FinancialYearDTO> get(int financialYearId) {

        Mono<FinancialYear> mono = repository.findById(financialYearId);

        FinancialYear block = mono.block();

        if (Objects.isNull(block)) throw new RuntimeException("FinancialYear not found by id - " + financialYearId);

        FinancialYearDTO dto = mapper.toDTO(block);

        return Mono.just(dto);
    }


    public Flux<FinancialYearDTO> getAll() {

        Flux<FinancialYear> all = repository.findAll();

        List<FinancialYear> block = all.collectList().block();

        List<FinancialYearDTO> dto = mapper.toDTO(Objects.requireNonNull(block));

        return Flux.fromIterable(dto);

    }

}
