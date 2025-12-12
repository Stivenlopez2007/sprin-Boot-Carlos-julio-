package com.sena.crud_basic.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "payments")
public class Payment extends BaseEntity {

 
    @Column(name="payment_method",nullable = false,length = 50)
    private String paymentMethod;

    @Column(name="amount",nullable = false)
    private BigDecimal amount;

    @Column(name="status",nullable = false,length = 20)
    private String status;

    @Column(name="payment_date",nullable = false,length = 50)
    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    

}
