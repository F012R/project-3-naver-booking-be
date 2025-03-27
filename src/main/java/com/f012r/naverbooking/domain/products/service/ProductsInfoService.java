package com.f012r.naverbooking.domain.products.service;

import com.f012r.naverbooking.domain.products.dto.ProductsInfoResponseDTO;
import com.f012r.naverbooking.domain.products.entity.DisplayInfo;
import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.repository.ProductImageRepository;
import com.f012r.naverbooking.domain.products.repository.ProductsRepository;
import com.f012r.naverbooking.domain.products.repository.DisplayInfoRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.ImageNotFoundException;
import com.f012r.naverbooking.global.exception.custom.InvalidDisplayInfoIdException;
import com.f012r.naverbooking.global.exception.custom.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsInfoService {

    private final ProductsRepository productsRepository;
    private final ProductImageRepository productImageRepository;
    private final DisplayInfoRepository displayInfoRepository;

    public ProductsInfoService(ProductsRepository productsRepository, ProductImageRepository productImageRepository, DisplayInfoRepository displayInfoRepository) {
        this.productsRepository = productsRepository;
        this.productImageRepository = productImageRepository;
        this.displayInfoRepository = displayInfoRepository;
    }

    public ProductsInfoResponseDTO getProductInfo(Integer displayInfoId) {

        DisplayInfo displayInfo = displayInfoRepository.findById(displayInfoId)
                .orElseThrow(() -> new InvalidDisplayInfoIdException(ResponseCode.InvalidDisplayInfoIdException));

        Product product = displayInfo.getProduct();


        String mainImgUrl = getImageUrlByType(product, "ma");
        List<String> extraImgUrls = getImageUrlsByType(product, "et");

        return ProductsInfoResponseDTO.builder()
                .productId(product.getId())
                .mainImgUrl(mainImgUrl)
                .extraImgUrl(extraImgUrls)
                .description(product.getDescription())
                .content(product.getContent())
                .placeLot(displayInfo.getPlaceLot())
                .placeStreet(displayInfo.getPlaceStreet())
                .placeName(displayInfo.getPlaceName())
                .tel(displayInfo.getTel())
                .build();
    }

    private String getImageUrlByType(Product product, String type) {
        return productImageRepository.findFirstByProductAndType(product, type)
                .map(productImage -> "/" + productImage.getFile().getSaveFileName())
                .orElseThrow(() -> new ImageNotFoundException(ResponseCode.ImageNotFoundException));
    }

    private List<String> getImageUrlsByType(Product product, String type) {
        return productImageRepository.findByProductAndType(product, type).stream()
                .map(productImage -> "/" + productImage.getFile().getSaveFileName())
                .collect(Collectors.toList());
    }
}
