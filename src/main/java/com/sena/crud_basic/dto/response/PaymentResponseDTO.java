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
public class PaymentResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private BigDecimal amount;

    @JsonView(JsonViews.Resumen.class)
    private String status;

    @JsonView(JsonViews.Resumen.class)
    private String paymentMethod;

    @JsonView(JsonViews.Resumen.class)
    private LocalDate paymentDate;

    @JsonView(JsonViews.Detalle.class)
    private Long orderId;

    @JsonView(JsonViews.Detalle.class)
    private String orderNumber;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
