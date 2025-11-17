package com.sena.crudbase.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank")
    private int id;

    @Column(name = "bank_name", length = 100)
    private String bankName;

    @Column(name = "min_interest_rate")
    private double minInterestRate;

    @Column(name = "max_interest_rate")
    private double maxInterestRate;

    @Column(name = "max_term_months")
    private int maxTermMonths;

    @OneToMany(mappedBy = "bank")  // Un banco tiene muchos financiamientos
    private List<Financing> financings;
}

