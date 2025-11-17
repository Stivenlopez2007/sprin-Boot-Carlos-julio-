package com.sena.crudbase.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feature")
    private int id;

    @Column(name = "feature_name", length = 100)
    private String featureName;

    @Column(name = "feature_type", length = 50)
    private String featureType;

    @Column(name = "data_type", length = 50)
    private String dataType;

    @Column(name = "description", length = 200)
    private String description;

    // RELACIÓN DEL MER: una característica puede aparecer en muchos autos
    @OneToMany(mappedBy = "feature")
    private List<CarFeature> carFeatures;
}

}
