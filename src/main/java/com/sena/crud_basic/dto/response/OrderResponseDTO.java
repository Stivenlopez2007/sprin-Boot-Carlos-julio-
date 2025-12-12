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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String orderNumber;

    @JsonView(JsonViews.Resumen.class)
    private String status;

    @JsonView(JsonViews.Resumen.class)
    private BigDecimal total;

    @JsonView(JsonViews.Resumen.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private String customerName;

    @JsonView(JsonViews.Detalle.class)
    private List<OrderItemResponseDTO> items;

    @JsonView(JsonViews.Detalle.class)
    private BigDecimal subtotal;

    @JsonView(JsonViews.Detalle.class)
    private BigDecimal tax;

    @JsonView(JsonViews.Detalle.class)
    private BigDecimal shippingCost;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
