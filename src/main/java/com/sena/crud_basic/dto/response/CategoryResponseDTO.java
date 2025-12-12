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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Resumen.class)
    private String slug;

    @JsonView(JsonViews.Detalle.class)
    private String description;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
