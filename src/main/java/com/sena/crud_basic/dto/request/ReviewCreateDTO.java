package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.*;
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
public class ReviewCreateDTO {

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productId;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long customerId;

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 1, message = "La calificación mínima es 1")
    @Max(value = 5, message = "La calificación máxima es 5")
    private Integer rating;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no debe exceder los 100 caracteres")
    private String title;

    @Size(max = 500, message = "El comentario no debe exceder los 500 caracteres")
    private String comment;

    @NotNull(message = "Debe indicar si es compra verificada")
    private Boolean isVerifiedPurchase;
}
