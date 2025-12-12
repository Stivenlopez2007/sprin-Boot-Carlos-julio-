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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressCreateDTO {

    // @NotNull        // No puede ser null
    //@NotBlank       // No puede ser null, vacío o solo espacios (String)
    //@NotEmpty       // No puede ser null o vacío (Strings, Collections)
    //@Size(min=, max=)  // Tamaño mínimo/máximo
    //@Min(value)     // Valor mínimo (números)
    //@Max(value)     // Valor máximo (números)
    //@Email          // Debe ser email válido
    //@Pattern(regexp="")  // Debe coincidir con expresión regular
    //@Past           // Fecha en el pasado
    //@Future         // Fecha en el futuro
    //@Positive       // Número positivo
    //@PositiveOrZero // Número positivo o cero
    //@DecimalMin     // Valor decimal mínimo
    //@DecimalMax     // Valor decimal máximo
        
    @NotBlank(message = "calle es obligatoria")
    @Size(min = 2, max = 50, message = "la calle debe tener entre 2 y 50 caracteres")
    private String street;

    @NotBlank(message = "El tipo de dirección es obligatorio")
    @Size(min = 2, max = 20, message = "El tipo de dirección debe tener entre 2 y 20 caracteres")
    private String addressType;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 5, max = 250, message = "La dirección debe tener entre 5 y 250 caracteres")
    private String streetAddress;

  
    @NotBlank(message = "La ciudad es obligatoria")
    @Size(min = 2, max = 50, message = "La ciudad debe tener entre 2 y 50 caracteres")
    private String city;

    @NotBlank(message = "El estado es obligatorio")
    @Size(min = 2, max = 50, message = "El estado debe tener entre 2 y 50 caracteres")
    private String state;

    @NotBlank(message = "El código postal es obligatorio")
    @Size(min = 2, max = 20, message = "El código postal debe tener entre 2 y 20 caracteres")
    private String postalCode;

    @NotBlank(message = "El país es obligatorio")
    @Size(min = 2, max = 50, message = "El país debe tener entre 2 y 50 caracteres")
    private String country;

}
