package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDTO {

    @NotBlank(message = "El estado del pedido es obligatorio")
    @Size(max = 50, message = "El estado no puede tener más de 50 caracteres")
    private String status;

    @NotNull(message = "El monto total es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto total debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El monto total debe tener máximo 10 enteros y 2 decimales")
    private BigDecimal totalAmount;

    @Size(max = 500, message = "La dirección de envío no puede tener más de 500 caracteres")
    private String shippingAddress;
}
