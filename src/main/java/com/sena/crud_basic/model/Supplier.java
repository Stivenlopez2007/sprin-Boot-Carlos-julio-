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
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

  

    @Column(name="name",nullable = false,length = 100)
    private String name;

    @Column(name="contact_name",nullable = false,length = 100)
    private String contactName;

    @Column(name="email",nullable = false,length = 100)
    private String email;

    @Column(name="phone",nullable = true,length = 20)
    private String phone;

    @Column(name="address",nullable = true,length = 200)
    private String address;

    @Column(name="city",nullable = true,length = 50)
    private String city;

    @Column(name="country",nullable = true,length = 50)
    private String country;

    
}
