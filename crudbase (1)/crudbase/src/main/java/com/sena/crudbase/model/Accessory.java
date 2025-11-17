package com.sena.crudbase.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accessory")
    private int id;

    @Column(name = "accessory_name", length = 100)
    private String accessoryName;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @OneToMany(mappedBy = "accessory")  
    private List<SaleAccessory> saleAccessories;
}

    