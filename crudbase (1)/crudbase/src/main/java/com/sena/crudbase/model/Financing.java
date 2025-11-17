package com.sena.crudbase.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "financing")
public class Financing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_financing")
    private int id;

    @Column(name = "financed_amount")
    private double financedAmount;

    @Column(name = "interest_rate")
    private double interestRate;

    @Column(name = "term_months")
    private int termMonths;

    @Column(name = "monthly_payment")
    private double monthlyPayment;

    @Column(name = "approval_date")
    private Date approvalDate;

   
    @ManyToOne
    @JoinColumn(name = "id_bank")
    private Bank bank;

    @OneToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;
}

