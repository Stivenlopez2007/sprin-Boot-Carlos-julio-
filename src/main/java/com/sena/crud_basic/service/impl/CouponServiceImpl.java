package com.sena.crud_basic.service.impl;

import com.sena.crud_basic.dto.request.CouponCreateDTO;
import com.sena.crud_basic.dto.response.CouponResponseDTO;
import com.sena.crud_basic.model.Coupon;
import com.sena.crud_basic.repository.CouponRepository;
import com.sena.crud_basic.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponServiceImpl extends GenericServiceImpl<Coupon, CouponCreateDTO, CouponResponseDTO, Long> 
        implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public CouponResponseDTO findByCode(String code) {
        Coupon coupon = couponRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Cupón no encontrado con código: " + code));
        return mapToResponse(coupon);
    }

    @Override
    public boolean existsByCode(String code) {
        return couponRepository.existsByCode(code);
    }

    @Override
    protected Coupon mapToEntity(CouponCreateDTO dto) {
        if (couponRepository.existsByCode(dto.getCode())) {
            throw new RuntimeException("Ya existe un cupón con el código: " + dto.getCode());
        }

        return Coupon.builder()
                .code(dto.getCode())
                .description(dto.getDescription())
                .discountType(dto.getDiscountType())
                .discountValue(dto.getDiscountValue())
                .minPurchaseAmount(dto.getMinPurchaseAmount())
                .maxUses(dto.getMaxUses())
                .usedCount(0)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .isActive(dto.getIsActive())
                .build();
    }

    @Override
    protected void updateEntity(Coupon coupon, CouponCreateDTO dto) {
        if (!coupon.getCode().equals(dto.getCode()) && couponRepository.existsByCode(dto.getCode())) {
            throw new RuntimeException("Ya existe un cupón con el código: " + dto.getCode());
        }

        coupon.setCode(dto.getCode());
        coupon.setDescription(dto.getDescription());
        coupon.setDiscountType(dto.getDiscountType());
        coupon.setDiscountValue(dto.getDiscountValue());
        coupon.setMinPurchaseAmount(dto.getMinPurchaseAmount());
        coupon.setMaxUses(dto.getMaxUses());
        coupon.setStartDate(dto.getStartDate());
        coupon.setEndDate(dto.getEndDate());
        coupon.setIsActive(dto.getIsActive());
    }

    @Override
    protected CouponResponseDTO mapToResponse(Coupon coupon) {
        return CouponResponseDTO.builder()
                .id(coupon.getId())
                .code(coupon.getCode())
                .description(coupon.getDescription())
                .discountType(coupon.getDiscountType())
                .discountValue(coupon.getDiscountValue())
                .minPurchaseAmount(coupon.getMinPurchaseAmount())
                .maxUses(coupon.getMaxUses())
                .usedCount(coupon.getUsedCount())
                .startDate(coupon.getStartDate())
                .endDate(coupon.getEndDate())
                .isActive(coupon.getIsActive())
                .createdAt(coupon.getCreatedAt())
                .updatedAt(coupon.getUpdatedAt())
                .build();
    }

    @Override
    protected JpaRepository<Coupon, Long> getRepository() {
        return couponRepository;
    }

    @Override
    protected String getEntityName() {
        return "Cupón";
    }
}
