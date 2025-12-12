package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.ProductCreateDTO;
import com.sena.crud_basic.dto.request.ProductUpdateDTO;
import com.sena.crud_basic.dto.response.ProductResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "API para gestión de productos")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductUpdateDTO dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sku/{sku}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProductResponseDTO> getProductBySku(@PathVariable String sku) {
        return ResponseEntity.ok(productService.findBySku(sku));
    }

    @GetMapping("/active")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ProductResponseDTO>> getActiveProducts() {
        return ResponseEntity.ok(productService.findByActiveTrue());
    }

    @GetMapping("/search")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ProductResponseDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.filterByName(name));
    }
}
