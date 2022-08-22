package com.example.financial_year_service.financialYear;

import com.example.financial_year_service.financialYear.dto.FinancialYearCreateDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

        return repository.save(mapper.fromUpdateDTO(dto));

    }


    public Mono<FinancialYearDTO> get(int financialYearId) {

        return repository.findById(financialYearId).map(mapper::toDTO);

    }


    public Flux<FinancialYearDTO> getAll() {

        return repository.findAll().map(mapper::toDTO);


//        Mono<List<FinancialYearDTO>> mono = all.collectList().map(mapper::toDTO);

//        mono.block().stream().forEach(System.out::println);

//        return mono.flatMapMany(Flux::fromIterable);
    }


}
