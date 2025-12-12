package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCreateDTO {

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long orderId;

    @NotBlank(message = "El método de pago es obligatorio")
    @Size(max = 50, message = "El método de pago no puede tener más de 50 caracteres")
    private String paymentMethod;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "El monto debe tener máximo 10 enteros y 2 decimales")
    private BigDecimal amount;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDateTime paymentDate;

    @NotBlank(message = "El ID de transacción es obligatorio")
    @Size(max = 200, message = "El ID de transacción no puede tener más de 200 caracteres")
    private String transactionId;

    @NotBlank(message = "El estado del pago es obligatorio")
    @Size(max = 50, message = "El estado no puede tener más de 50 caracteres")
    private String status;
}
