package com.f012r.naverbooking.domain.products.dto;

import lombok.Getter;
import lombok.Builder;

import java.util.List;

@Getter
@Builder
public class ProductsResponseDTO {

    private int totalCount;
    private List<ProductDTO> items;

    @Getter
    @Builder
    public static class ProductDTO{
        private int id;
        private int CategoryId;
        private String description;
        private String content;
        private String placeName;
        private String productImgUrl;

    }

}