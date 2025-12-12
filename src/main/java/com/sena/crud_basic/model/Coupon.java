package com.sena.crud_basic.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "coupons")
public class Coupon  extends BaseEntity {

    @Column(name="code", nullable = false, unique = true)
    private String code;

    @Column(name ="description" , nullable = false)
    private String description;

    @Column(name = "discount_Type", nullable = false,length = 20)
    private String discountType;

    @Column(name = "discount_value", nullable = false)
    private BigDecimal discountValue;

    @Column(name="min_purchase_amount", nullable = false)
    private BigDecimal minPurchaseAmount;

    @Column(name="max_uses", nullable = false)
    private Integer maxUses;

    @Column(name="used_count", nullable = false)
    private Integer usedCount;

    @Column(name="start_date", nullable = false)
    private LocalDate startDate;

    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @Column(name="is_active", nullable = false)
    private Boolean isActive;

  

}
