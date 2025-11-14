package com.sena.crudbase.model;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "vendedor")
public class VendedorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_vendedor")
    private int id; 

    @Column(name = "nombre",length = 100) 
    private String nombre;

    @Column(name = "apellido",length = 100 )
    private String apellido;
    
    @Column(name = "dni", length = 100 )
    private int dni;

    @Column(name = "telefono",length = 100)
    private int telefono;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "fecha_contratacion",length = 100)
    private Date fecha_contratacion;

    @Column(name = "comisicion",length = 100)
    private String comisicion;



}



/*@Entity(name="stiven")
public class stivenDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    
    @Column(name = "stiven")
    private String  name;
    */