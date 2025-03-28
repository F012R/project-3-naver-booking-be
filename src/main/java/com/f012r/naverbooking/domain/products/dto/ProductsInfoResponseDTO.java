package com.f012r.naverbooking.domain.products.dto;

import lombok.Getter;
import lombok.Builder;

import java.util.List;

@Getter
@Builder
public class ProductsInfoResponseDTO {

    private Integer productId;
    private String mainImgUrl;
    private List<String> extraImgUrl;
    private String description;
    private String content;
    private String placeLot;
    private String placeStreet;
    private String placeName;
    private String tel;

}
