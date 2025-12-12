package com.sena.crud_basic.dto.response;

import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.view.JsonViews;

import lombok.Builder;


@lombok.Data
@Builder
public class CustomerResponseDTO {
    
    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String firstName;

    @JsonView(JsonViews.Resumen.class)
    private String lastName;

    @JsonView(JsonViews.Resumen.class)
    private String email;

    @JsonView(JsonViews.Detalle.class)
    private String phone;

    @JsonView(JsonViews.Detalle.class)
    private LocalDate dateOfBirth;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;

}
