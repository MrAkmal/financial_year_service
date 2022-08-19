package com.example.financial_year_service.financialYear.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinancialYearDTO {


    private int id;

    private String financialYear;

    private boolean isDefault;

}
