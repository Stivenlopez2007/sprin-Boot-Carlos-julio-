package com.sena.crud_basic.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

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
@Table(name = "customers")
public class Customer  extends BaseEntity {


    @Column(name="first_name",nullable = false,length = 100)
    private String firstName;

    @Column(name="last_name",nullable = false,length = 100)
    private String lastName;

    @Column(name="email",nullable = false,length = 150)
    private String email;

    @Column(name="phone",nullable = false,length = 20)
    private String phone;

    @Column(name="password",nullable = false,length = 200)
    private String password;

    @Column(name="date_of_birth",nullable = true,length = 50)
    private LocalDate dateOfBirth;


// agregar la n cantidad de columnas

    


}
