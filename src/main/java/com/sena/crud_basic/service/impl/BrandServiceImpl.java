package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.BrandCreateDTO;
import com.sena.crud_basic.dto.response.BrandResponseDTO;
import com.sena.crud_basic.model.Brand;
import com.sena.crud_basic.repository.BrandRepository;
import com.sena.crud_basic.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BrandServiceImpl extends GenericServiceImpl<Brand, BrandCreateDTO, BrandResponseDTO, Long> 
        implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public BrandResponseDTO findByName(String name) {
        Brand brand = brandRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con nombre: " + name));
        return mapToResponse(brand);
    }

    @Override
    public List<BrandResponseDTO> findByActiveTrue() {
        return brandRepository.findByActiveTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    protected Brand mapToEntity(BrandCreateDTO dto) {
        if (brandRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Ya existe una marca con el nombre: " + dto.getName());
        }

        return Brand.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .logoUrl(dto.getLogoUrl())
                .websiteUrl(dto.getWebsiteUrl())
                .active(dto.getActive())
                .build();
    }

    @Override
    protected void updateEntity(Brand brand, BrandCreateDTO dto) {
        if (!brand.getName().equals(dto.getName()) && brandRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Ya existe una marca con el nombre: " + dto.getName());
        }

        brand.setName(dto.getName());
        brand.setDescription(dto.getDescription());
        brand.setLogoUrl(dto.getLogoUrl());
        brand.setWebsiteUrl(dto.getWebsiteUrl());
        brand.setActive(dto.getActive());
    }

    @Override
    protected BrandResponseDTO mapToResponse(Brand brand) {
        return BrandResponseDTO.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .logoUrl(brand.getLogoUrl())
                .websiteUrl(brand.getWebsiteUrl())
                .active(brand.getActive())
                .createdAt(brand.getCreatedAt())
                .updatedAt(brand.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Brand, Long> getRepository() {
        return brandRepository;
    }

    @Override
    protected String getEntityName() {
        return "Marca";
    }
}
