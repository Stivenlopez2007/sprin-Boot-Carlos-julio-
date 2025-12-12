package com.sena.crud_basic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.view.JsonViews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String code;

    @JsonView(JsonViews.Resumen.class)
    private String discountType;

    @JsonView(JsonViews.Resumen.class)
    private BigDecimal discountValue;

    @JsonView(JsonViews.Resumen.class)
    private Boolean isActive;

    @JsonView(JsonViews.Detalle.class)
    private String description;

    @JsonView(JsonViews.Detalle.class)
    private BigDecimal minPurchaseAmount;

    @JsonView(JsonViews.Detalle.class)
    private Integer maxUses;

    @JsonView(JsonViews.Detalle.class)
    private Integer usedCount;

    @JsonView(JsonViews.Detalle.class)
    private LocalDate startDate;

    @JsonView(JsonViews.Detalle.class)
    private LocalDate endDate;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
