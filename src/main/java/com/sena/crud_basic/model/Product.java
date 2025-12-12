package com.sena.crud_basic.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
 
    @Column(name="name",nullable = false,length = 100)
    private String name;

    @Column(name="description",nullable = true,length = 500)
    private String description;

    @Column(name="price",nullable = false)
    private BigDecimal price;

    @Column(name="stock",nullable = false)
    private Integer stock;

    @Column(name="sku",nullable = false,length = 100)
    private String sku;

    @Column(name="is_active",nullable = false)
    private Boolean active ;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "product")
    private List<CategoryProduct> categoryProducts;

}
