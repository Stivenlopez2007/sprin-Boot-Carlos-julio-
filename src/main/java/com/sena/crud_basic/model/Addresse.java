package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "addresses")
public class Addresse  extends BaseEntity {


    
    @Column(name="street",nullable = false,length = 50)
    private String street;

    @Column(name="address_type",nullable = false,length = 20)
    private String addressType;

    @Column(name="street_address",nullable = false,length = 250)
    private String streetAddress;

    @Column(name="city",nullable = false,length = 50)
    private String city;

    @Column(name="state",nullable = false,length = 50)
    private String state;

    @Column(name="postal_code",nullable = false,length = 20)
    private String postalCode;

    @Column(name="country",nullable = false,length = 50)
    private String country;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    

}
