package com.sena.crudbase.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seller")
    private int id;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "dni", length = 20)
    private String dni;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "commission_percentage")
    private double commissionPercentage;

    //  RELACIÓN CORRECTA DEL MER
    @OneToMany(mappedBy = "seller")
    private List<Sale> sales;
}




}



/*@Entity(name="stiven")
public class stivenDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    
    @Column(name = "stiven")
    private String  name;
    */