package com.f012r.naverbooking.domain.promotions.service;

import com.f012r.naverbooking.domain.products.entity.FileInfo;
import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.entity.ProductImage;
import com.f012r.naverbooking.domain.products.repository.ProductImageRepository;
import com.f012r.naverbooking.domain.promotions.dto.PromotionsResponseDTO;
import com.f012r.naverbooking.domain.promotions.entity.Promotion;
import com.f012r.naverbooking.domain.promotions.repository.PromotionsRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.ImageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionsService {

    private PromotionsRepository promotionsRepository;
    private ProductImageRepository productImageRepository;

    @Autowired
    public PromotionsService(PromotionsRepository promotionsRepository,
                             ProductImageRepository productImageRepository) {
        this.promotionsRepository = promotionsRepository;
        this.productImageRepository = productImageRepository;
    }

    public PromotionsResponseDTO getPromotions() {
        List<PromotionsResponseDTO.PromotionDTO> promotionDTOList = new ArrayList<>();
        List<Promotion> promotions = promotionsRepository.findAll();

        for (Promotion promotion : promotions) {
            int promotionId = promotion.getId();
            int productId;
            String productImageUrl;

            Product promotionedProduct = promotion.getProduct();
            productId = promotionedProduct.getId();

            Optional<ProductImage> productImageOptional = productImageRepository.findFirstByProductAndType(promotionedProduct, "th");
            if (productImageOptional.isPresent()) {
                ProductImage productImage = productImageOptional.get();
                FileInfo file = productImage.getFile();
                productImageUrl = file.getSaveFileName();
            } else {
                throw new ImageNotFoundException(ResponseCode.ImageNotFoundException);
            }

            PromotionsResponseDTO.PromotionDTO promotionDTO = PromotionsResponseDTO.PromotionDTO.builder()
                    .id(promotionId)
                    .productId(productId)
                    .productImageUrl("/" + productImageUrl)
                    .build();

            promotionDTOList.add(promotionDTO);
        }

        return PromotionsResponseDTO.builder()
                .totalCount(promotions.size())
                .items(promotionDTOList)
                .build();
    }
}
