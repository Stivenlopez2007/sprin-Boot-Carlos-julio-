package com.sena.crudbase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "sale_accessory")
public class SaleAccessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale_accessory")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "subtotal")
    private double subtotal;

    //  RELACIÓN CORRECTA DEL MER: muchos accesorios vendidos pertenecen a una venta
    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;

    // RELACIÓN: cada registro pertenece a un accesorio
    @ManyToOne
    @JoinColumn(name = "id_accessory")
    private Accessory accessory;
}

