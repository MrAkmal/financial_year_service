package com.example.financial_year_service.financialYear;

import com.example.financial_year_service.financialYear.dto.FinancialYearCreateDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearDTO;
import com.example.financial_year_service.financialYear.dto.FinancialYearUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/financial-year")
public class FinancialYearController {


    private final FinancialYearService service;

    @Autowired
    public FinancialYearController(FinancialYearService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody FinancialYearCreateDTO dto) {
        Integer id = service.save(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody FinancialYearUpdateDTO dto) {
        Integer id = service.update(dto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int deletedId) {
        Integer id = service.delete(deletedId);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FinancialYearDTO> get(@PathVariable("id") int id) {
        FinancialYearDTO dto = service.get(id);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FinancialYearDTO>> getAll() {
        List<FinancialYearDTO> dto = service.getAll();

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
