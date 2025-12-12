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
public class BrandResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Resumen.class)
    private String logoUrl;

    @JsonView(JsonViews.Resumen.class)
    private Boolean active;

    @JsonView(JsonViews.Detalle.class)
    private String description;

    @JsonView(JsonViews.Detalle.class)
    private String websiteUrl;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
