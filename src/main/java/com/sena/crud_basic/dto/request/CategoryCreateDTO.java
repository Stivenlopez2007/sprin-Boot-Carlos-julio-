package com.sena.crud_basic.dto.request;


import jakarta.validation.constraints.NotBlank;
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
public class CategoryCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no debe exceder los 255 caracteres")
    private String description;

    @NotBlank(message = "El slug es obligatorio")
    @Size(min = 2, max = 150, message = "El slug debe tener entre 2 y 150 caracteres")
    private String slug;


}
