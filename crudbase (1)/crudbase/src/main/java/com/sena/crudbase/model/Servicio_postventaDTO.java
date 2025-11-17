package com.sena.crudbase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_model")
    private int id;

    @Column(name = "model_name", length = 50)
    private String modelName;

    @Column(name = "type", length = 30)
    private String type;

    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    @Column(name = "fuel_type", length = 20)
    private String fuelType;

    // Many models belong to one brand
    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

}
