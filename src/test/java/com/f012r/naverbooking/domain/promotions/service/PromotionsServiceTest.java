package com.f012r.naverbooking.domain.promotions.service;

import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.repository.ProductImageRepository;
import com.f012r.naverbooking.domain.promotions.entity.Promotion;
import com.f012r.naverbooking.domain.promotions.repository.PromotionsRepository;
import com.f012r.naverbooking.global.exception.custom.ImageNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PromotionsServiceTest {

    @InjectMocks
    private PromotionsService promotionsService;

    @Mock
    private ProductImageRepository productImageRepository;

    @Mock
    private PromotionsRepository promotionsRepository;

    @Test
    public void testGetPromotions_ImageNotFoundException() {
        // given
        Product product = new Product();
        product.setId(1);
        Promotion promotion = new Promotion();
        promotion.setId(1);
        promotion.setProduct(product);

        Mockito.when(promotionsRepository.findAll()).thenReturn(Collections.singletonList(promotion));
        Mockito.when(productImageRepository.findFirstByProductAndType(product, "th")).thenReturn(Optional.empty());

        // when & then
        assertThrows(ImageNotFoundException.class, () -> {
            promotionsService.getPromotions();
        });
    }
}

