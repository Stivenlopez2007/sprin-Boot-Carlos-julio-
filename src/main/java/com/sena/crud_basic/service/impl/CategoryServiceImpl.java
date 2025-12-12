package com.sena.crud_basic.service.impl;
import com.sena.crud_basic.dto.request.CategoryCreateDTO;
import com.sena.crud_basic.dto.response.CategoryResponseDTO;
import com.sena.crud_basic.model.Category;
import com.sena.crud_basic.repository.CategoryRepository;
import com.sena.crud_basic.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryCreateDTO, CategoryResponseDTO, Long> 
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO findBySlug(String slug) {
        Category category = categoryRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con slug: " + slug));
        return mapToResponse(category);
    }

    @Override
    public boolean existsBySlug(String slug) {
        return categoryRepository.existsBySlug(slug);
    }

    @Override
    protected Category mapToEntity(CategoryCreateDTO dto) {
        // Validar slug único
        if (categoryRepository.existsBySlug(dto.getSlug())) {
            throw new RuntimeException("Ya existe una categoría con el slug: " + dto.getSlug());
        }

        return Category.builder()
                .name(dto.getName())
                .slug(dto.getSlug())
                .description(dto.getDescription())
                .build();
    }

    @Override
    protected void updateEntity(Category category, CategoryCreateDTO dto) {
        // Validar slug único si cambió
        if (!category.getSlug().equals(dto.getSlug()) && categoryRepository.existsBySlug(dto.getSlug())) {
            throw new RuntimeException("Ya existe una categoría con el slug: " + dto.getSlug());
        }

        category.setName(dto.getName());
        category.setSlug(dto.getSlug());
        category.setDescription(dto.getDescription());
    }

    @Override
    protected CategoryResponseDTO mapToResponse(Category category) {
        return CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }

    @Override
    protected String getEntityName() {
        return "Categoría";
    }
}
