package com.sena.crud_basic.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

import lombok.Builder;


@lombok.Data
@Builder
public class CustomerCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, min=2, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max=100,min=2, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String lastName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Size(max = 150)
    private String email;

   @NotBlank(message = "El teléfono es obligatorio")
   @Pattern(regexp = "^[0-9]{10,20}$", message = "El teléfono debe tener entre 10 y 20 dígitos")
    private String phone;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 200, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate dateOfBirth;

}
