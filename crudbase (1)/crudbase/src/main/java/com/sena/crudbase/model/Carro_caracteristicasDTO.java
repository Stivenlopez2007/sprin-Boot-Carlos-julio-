package com.sena.crudbase.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "car_feature")
public class CarFeature {


     @Column(name = "value", length = 200)
    private String value;

    @EmbeddedId
    private CarFeatureId id;

   

   
}
@Entity(name = "car_feature")
public class CarFeature {

    @EmbeddedId
    private CarFeatureId id;

    @ManyToOne
    @JoinColumn(name = "id_car", insertable = false, updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_feature", insertable = false, updatable = false)
    private Feature feature;

    @Column(name = "value", length = 200)
    private String value;
}
