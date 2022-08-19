package com.example.financial_year_service.financialYear.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinancialYearCreateDTO {


    private String year;

    private boolean isDefault;

}
