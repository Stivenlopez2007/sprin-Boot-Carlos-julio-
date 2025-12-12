package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandCreateDTO {

    @NotBlank(message = "nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;
    
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 500, message = "La descripción no debe exceder los 500 caracteres")
    private String description;

    @NotBlank(message = "La URL del logo es obligatoria")
    @Size(max = 250, message = "La URL del logo no debe exceder los 250 caracteres")
    private String logoUrl;

    @NotBlank(message = "La URL del sitio web es obligatoria")
    @Size(max = 250, message = "La URL del sitio web no debe exceder los 250 caracteres")
    private String websiteUrl;

    @NotNull(message = "El estado es obligatorio")
    private Boolean active;

}
