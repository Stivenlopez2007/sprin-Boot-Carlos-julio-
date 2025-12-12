package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.ReviewCreateDTO;
import com.sena.crud_basic.dto.response.ReviewResponseDTO;
import com.sena.crud_basic.model.Review;
import com.sena.crud_basic.model.Product;
import com.sena.crud_basic.model.Customer;
import com.sena.crud_basic.repository.ReviewRepository;
import com.sena.crud_basic.repository.ProductRepository;
import com.sena.crud_basic.repository.CustomerRepository;
import com.sena.crud_basic.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl extends GenericServiceImpl<Review, ReviewCreateDTO, ReviewResponseDTO, Long> 
        implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<ReviewResponseDTO> findByProductId(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewResponseDTO> findByCustomerId(Long customerId) {
        return reviewRepository.findByCustomerId(customerId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    protected Review mapToEntity(ReviewCreateDTO dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + dto.getProductId()));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getCustomerId()));

        return Review.builder()
                .product(product)
                .customer(customer)
                .rating(dto.getRating())
                .title(dto.getTitle())
                .comment(dto.getComment())
                .isVerifiedPurchase(dto.getIsVerifiedPurchase())
                .build();
    }

    @Override
    protected void updateEntity(Review review, ReviewCreateDTO dto) {
        review.setRating(dto.getRating());
        review.setTitle(dto.getTitle());
        review.setComment(dto.getComment());
        review.setIsVerifiedPurchase(dto.getIsVerifiedPurchase());
    }

    @Override
    protected ReviewResponseDTO mapToResponse(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .title(review.getTitle())
                .comment(review.getComment())
                .isVerifiedPurchase(review.getIsVerifiedPurchase())
                .productName(review.getProduct().getName())
                .customerName(review.getCustomer().getFirstName() + " " + review.getCustomer().getLastName())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Review, Long> getRepository() {
        return reviewRepository;
    }

    @Override
    protected String getEntityName() {
        return "Reseña";
    }
}
