package com.sena.crud_basic.model;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "orders")
public class Order extends BaseEntity {
    

    @Column(name="order_number",nullable = false,length = 50)
    private String orderNumber;

    @Column(name="status",nullable = false,length = 20)
    private String status;

    @Column(name="subtotal",nullable = false)
    private BigDecimal subtotal;

    @Column(name="tax",nullable = false)
    private BigDecimal tax;

    @Column(name="shipping_cost",nullable = false)
    private BigDecimal shippingCost;

    @Column(name="total",nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

}
