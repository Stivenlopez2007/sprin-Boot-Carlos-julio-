package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponCreateDTO {

    @NotBlank(message = "El código es obligatorio")
    @Size(max = 50, message = "El código no debe exceder los 50 caracteres")
    @Pattern(regexp = "^[A-Z0-9-]+$", message = "El código solo puede contener letras mayúsculas, números y guiones")
    private String code;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no debe exceder los 255 caracteres")
    private String description;

    @NotBlank(message = "El tipo de descuento es obligatorio")
    @Size(max = 20, message = "El tipo de descuento no debe exceder los 20 caracteres")
    @Pattern(regexp = "^(PERCENTAGE|FIXED)$", message = "El tipo debe ser PERCENTAGE o FIXED")
    private String discountType;

    @NotNull(message = "El valor del descuento es obligatorio")
    @DecimalMin(value = "0.01", message = "El valor del descuento debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "Formato de valor inválido")
    private BigDecimal discountValue;

    @NotNull(message = "El monto mínimo de compra es obligatorio")
    @DecimalMin(value = "0.00", message = "El monto mínimo no puede ser negativo")
    @Digits(integer = 10, fraction = 2, message = "Formato de monto inválido")
    private BigDecimal minPurchaseAmount;

    @NotNull(message = "El máximo de usos es obligatorio")
    @Min(value = 1, message = "El máximo de usos debe ser al menos 1")
    private Integer maxUses;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate startDate;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Future(message = "La fecha de fin debe ser futura")
    private LocalDate endDate;

    @NotNull(message = "El estado es obligatorio")
    private Boolean isActive;
}
