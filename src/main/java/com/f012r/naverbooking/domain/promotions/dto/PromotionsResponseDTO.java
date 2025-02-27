package com.f012r.naverbooking.domain.promotions.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PromotionsResponseDTO {

    private int totalCount;
    private List<PromotionsResponseDTO.PromotionDTO> items;

    @Getter
    @Builder
    public static class PromotionDTO {
        private int id;
        private int productId;
        private String productImageUrl;
    }
}
