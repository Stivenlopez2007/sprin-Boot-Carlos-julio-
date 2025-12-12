package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.ProductCreateDTO;
import com.sena.crud_basic.dto.request.ProductUpdateDTO;
import com.sena.crud_basic.dto.response.ProductResponseDTO;
import com.sena.crud_basic.model.Product;
import com.sena.crud_basic.repository.ProductRepository;
import com.sena.crud_basic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl extends GenericServiceImpl<Product, ProductCreateDTO, ProductResponseDTO, Long> 
        implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductResponseDTO update(Long id, ProductUpdateDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        updateEntity(product, dto);
        Product updated = productRepository.save(product);
        return mapToResponse(updated);
    }

    @Override
    public ProductResponseDTO findBySku(String sku) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con SKU: " + sku));
        return mapToResponse(product);
    }

    @Override
    public List<ProductResponseDTO> findByActiveTrue() {
        return productRepository.findByActiveTrue().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }

    @Override
    public List<ProductResponseDTO> filterByName(String name) {
        return productRepository.findAll().stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    protected Product mapToEntity(ProductCreateDTO dto) {
        if (productRepository.existsBySku(dto.getSku())) {
            throw new RuntimeException("Ya existe un producto con el SKU: " + dto.getSku());
        }

        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .sku(dto.getSku())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .active(dto.getActive())
                .build();
    }

    @Override
    protected void updateEntity(Product product, ProductCreateDTO dto) {
        // Método no usado directamente
    }

    protected void updateEntity(Product product, ProductUpdateDTO dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setActive(dto.getActive());
    }

    @Override
    protected ProductResponseDTO mapToResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .sku(product.getSku())
                .price(product.getPrice())
                .stock(product.getStock())
                .active(product.getActive())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    @Override
    protected String getEntityName() {
        return "Producto";
    }
}
