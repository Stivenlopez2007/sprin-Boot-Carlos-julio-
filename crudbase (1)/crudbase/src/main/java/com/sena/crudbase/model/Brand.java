package com.sena.crudbase.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private int id;

    @Column(name = "brand_name", length = 50)
    private String brandName;

    @Column(name = "origin_country", length = 50)
    private String originCountry;

    @Column(name = "website", length = 100)
    private String website;

    // ✔ RELACIÓN CORRECTA SEGÚN TU MER
    // Una marca tiene muchos modelos
    @OneToMany(mappedBy = "brand")
    private List<Model> models;
}
