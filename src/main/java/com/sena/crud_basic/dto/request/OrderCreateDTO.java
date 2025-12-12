package com.sena.crud_basic.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCreateDTO {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long customerId;

    @NotNull(message = "El ID de la dirección es obligatorio")
    private Long addressId;

    @NotEmpty(message = "Debe agregar al menos un producto")
    @Valid  // Valida cada elemento de la lista
    private List<OrderItemDTO> items;

    // Opcional - para aplicar cupón de descuento
    private Long couponId;
}
