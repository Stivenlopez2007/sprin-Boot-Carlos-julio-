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
@Table(name = "reviews")   
public class Review extends BaseEntity {
  

    @Column(name="rating",nullable = false)
    private Integer rating;

    @Column(name="title",nullable = false,length = 100)
    private String title;

    @Column(name="comment",nullable = true,length = 500)
    private String comment;

    @Column(name="is_verified_purchase",nullable = false)
    private Boolean isVerifiedPurchase;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
}
