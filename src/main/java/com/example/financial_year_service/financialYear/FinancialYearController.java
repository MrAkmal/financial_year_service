package com.example.financial_year_service.financialYear;

import com.example.financial_year_service.financialYear.dto.FinancialYearCreateDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/financial-year")
public class FinancialYearController {


    private final FinancialYearService service;

    @Autowired
    public FinancialYearController(FinancialYearService service) {
        this.service = service;
    }


    @PostMapping
    public Mono<FinancialYear> save(@RequestBody FinancialYearCreateDTO dto) {
        return service.save(dto);

    }


    @PutMapping
    public Mono<FinancialYear> update(@RequestBody FinancialYearUpdateDTO dto) {
        return service.update(dto);

    }


    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") int deletedId) {
        return service.delete(deletedId);

    }


    @GetMapping("/{id}")
    public Mono<FinancialYearDTO> get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @GetMapping
    public Flux<FinancialYearDTO> getAll() {
        return service.getAll();
    }


}
