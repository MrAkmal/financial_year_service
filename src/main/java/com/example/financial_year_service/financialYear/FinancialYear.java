package com.example.financial_year_service.financialYear;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "financial_year")
public class FinancialYear {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String year;


    @Column(name = "is_default")
    private boolean isDefault;

}
