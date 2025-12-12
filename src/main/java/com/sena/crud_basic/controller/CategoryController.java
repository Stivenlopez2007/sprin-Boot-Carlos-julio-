package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crud_basic.dto.request.CategoryCreateDTO;
import com.sena.crud_basic.dto.response.CategoryResponseDTO;
import com.sena.crud_basic.dto.view.JsonViews;
import com.sena.crud_basic.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@Tag(name = "Categories", description = "API para gestión de categorías")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid @RequestBody CategoryCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CategoryResponseDTO> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody CategoryCreateDTO dto) {
        return ResponseEntity.ok(categoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/slug/{slug}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<CategoryResponseDTO> getCategoryBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(categoryService.findBySlug(slug));
    }
}
