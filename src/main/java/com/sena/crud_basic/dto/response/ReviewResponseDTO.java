package com.sena.crud_basic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.view.JsonViews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {

    @JsonView(JsonViews.Resumen.class)
    private Long id;

    @JsonView(JsonViews.Resumen.class)
    private Integer rating;

    @JsonView(JsonViews.Resumen.class)
    private String title;

    @JsonView(JsonViews.Resumen.class)
    private String customerName;

    @JsonView(JsonViews.Resumen.class)
    private Instant createdAt;

    @JsonView(JsonViews.Detalle.class)
    private String comment;

    @JsonView(JsonViews.Detalle.class)
    private Boolean isVerifiedPurchase;

    @JsonView(JsonViews.Detalle.class)
    private String productName;

    @JsonView(JsonViews.Detalle.class)
    private Instant updatedAt;
}
