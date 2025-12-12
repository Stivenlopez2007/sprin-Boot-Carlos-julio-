package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name="address_line1", nullable = false, length = 250)
    private String addressLine1;

    @Column(name="address_line2", length = 250)
    private String addressLine2;

    @Column(name="city", nullable = false, length = 50)
    private String city;

    @Column(name="state", nullable = false, length = 50)
    private String state;

    @Column(name="postal_code", nullable = false, length = 20)
    private String postalCode;

    @Column(name="country", nullable = false, length = 50)
    private String country;

    @Column(name="address_type", nullable = false, length = 20)
    private String addressType;
}
