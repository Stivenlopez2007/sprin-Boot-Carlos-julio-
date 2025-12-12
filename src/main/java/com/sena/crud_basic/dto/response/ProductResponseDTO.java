package com.sena.crud_basic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.view.JsonViews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Resumen.class)
    private BigDecimal price;

    @JsonView(JsonViews.Resumen.class)
    private String sku;

    @JsonView(JsonViews.Resumen.class)
    private Boolean active;

    @JsonView(JsonViews.Detalle.class)
    private String description;

    @JsonView(JsonViews.Detalle.class)
    private Integer stock;

    @JsonView(JsonViews.Detalle.class)
    private String brandName;

    @JsonView(JsonViews.Detalle.class)
    private List<String> categoryNames;

    @JsonView(JsonViews.Detalle.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
