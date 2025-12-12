package com.sena.crud_basic.dto.response;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.view.JsonViews;

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
public class AddressResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String addressType;

    @JsonView(JsonViews.Resumen.class)
    private String city;

    @JsonView(JsonViews.Resumen.class)
    private String country;

    @JsonView(JsonViews.Detalle.class)
    private String street;

    @JsonView(JsonViews.Detalle.class)
    private String streetAddress;

    @JsonView(JsonViews.Detalle.class)
    private String state;

    @JsonView(JsonViews.Detalle.class)
    private String postalCode;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
