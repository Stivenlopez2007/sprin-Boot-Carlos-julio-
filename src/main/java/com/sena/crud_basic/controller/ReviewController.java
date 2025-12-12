package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.ReviewCreateDTO;
import com.sena.crud_basic.dto.response.ReviewResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
@Tag(name = "Reviews", description = "API para gestión de reseñas de productos")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ReviewResponseDTO> createReview(@Valid @RequestBody ReviewCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id,
            @Valid @RequestBody ReviewCreateDTO dto) {
        return ResponseEntity.ok(reviewService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.findByProductId(productId));
    }

    @GetMapping("/customer/{customerId}")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(reviewService.findByCustomerId(customerId));
    }
}
