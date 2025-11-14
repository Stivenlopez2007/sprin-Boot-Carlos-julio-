package com.sena.crudbase.model;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "venta") // nombre entidad 
public class VentaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta")
    private int venta;
    
    @Column(name = "fecha_venta")
    private Date fecha_venta;

    @Column(name = "precio_final")
    private double precio_final;

    @Column(name = "metodo_pago")
    private String metodo_pago;
    
    @Column(name = "descuentos_aplicado")
    private double descuentos_aplicado;

    @ManyToAny
    
}

