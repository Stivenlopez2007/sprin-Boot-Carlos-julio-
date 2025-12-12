package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.BrandCreateDTO;
import com.sena.crud_basic.dto.response.BrandResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
@Tag(name = "Brands", description = "API para gestión de marcas")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<BrandResponseDTO>> getAllBrands() {
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BrandResponseDTO> getBrandById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BrandResponseDTO> createBrand(@Valid @RequestBody BrandCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BrandResponseDTO> updateBrand(
            @PathVariable Long id,
            @Valid @RequestBody BrandCreateDTO dto) {
        return ResponseEntity.ok(brandService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BrandResponseDTO> getBrandByName(@PathVariable String name) {
        return ResponseEntity.ok(brandService.findByName(name));
    }

    @GetMapping("/active")
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<BrandResponseDTO>> getActiveBrands() {
        return ResponseEntity.ok(brandService.findByActiveTrue());
    }
}
