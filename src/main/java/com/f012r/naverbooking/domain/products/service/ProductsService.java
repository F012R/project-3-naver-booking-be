package com.f012r.naverbooking.domain.products.service;

import com.f012r.naverbooking.domain.products.dto.ProductsResponseDTO;
import com.f012r.naverbooking.domain.products.entity.DisplayInfo;
import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.entity.ProductImage;
import com.f012r.naverbooking.domain.products.repository.ProductImageRepository;
import com.f012r.naverbooking.domain.products.repository.ProductsRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductImageRepository productImageRepository;

    public ProductsService(ProductsRepository productsRepository, ProductImageRepository productImageRepository) {
        this.productsRepository = productsRepository;
        this.productImageRepository = productImageRepository;

    }



    public List<ProductsResponseDTO.ProductDTO> getAllProducts() {
        List<Product> products = productsRepository.findAll();

        if(products.isEmpty()) {
            throw new ProductNotFoundException(ResponseCode.ProductNotFoundException);
        }

        return products.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());


    }

    private ProductsResponseDTO.ProductDTO convertToProductDTO(Product product) {
        String placeName = null;


        List<DisplayInfo> displayInfoList = product.getDisplayInfo();

        if (displayInfoList != null && !displayInfoList.isEmpty()) {
            placeName = displayInfoList.get(0).getPlaceName();
        }


        ProductImage thumbnailImage = productImageRepository.findFirstByProductAndType(product, "th").orElse(null);

        String productImgUrl = null;
        if (thumbnailImage != null) {
            String fileName = thumbnailImage.getFile().getSaveFileName();
            productImgUrl = "/" + fileName;
        }

        return ProductsResponseDTO.ProductDTO.builder()
                .id(product.getId())
                .CategoryId(product.getCategory().getId())
                .description(product.getDescription())
                .content(product.getContent())
                .placeName(placeName)
                .productImgUrl(productImgUrl)
                .build();
    }
}
