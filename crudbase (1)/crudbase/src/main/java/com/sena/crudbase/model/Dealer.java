package com.sena.crudbase.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "dealer")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dealer")
    private int id;

    @Column(name = "dealer_name", length = 100)
    private String dealerName;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "manager", length = 100)
    private String manager;

    // ✔ RELACIÓN: UN CONCESIONARIO TIENE MUCHOS CARROS
    @OneToMany(mappedBy = "dealer")
    private List<Car> cars;
}


