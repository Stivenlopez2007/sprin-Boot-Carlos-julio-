package com.sena.crud_basic.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
  
    @Column(name="name",nullable = false,length = 100)
    private String name;
    
    @Column(name="description",nullable = true,length = 500)
    private String description;

    @Column(name="logo_url",nullable = true,length = 250)
    private String logoUrl;

    @Column(name="website_url",nullable = true,length = 250)
    private String websiteUrl;

    @Column(name="is_active",nullable = false  )
    private Boolean active;

  

}
