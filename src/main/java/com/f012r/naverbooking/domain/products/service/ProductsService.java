package com.f012r.naverbooking.domain.products.service;

import com.f012r.naverbooking.domain.products.dto.ProductsResponseDTO;
import com.f012r.naverbooking.domain.products.entity.DisplayInfo;
import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.entity.ProductImage;
import com.f012r.naverbooking.domain.products.repository.ProductImageRepository;
import com.f012r.naverbooking.domain.products.repository.ProductsRepository;
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
        // ProductsRepository에서 DisplayInfo까지 함께 가져오기 위해 fetch join을 사용
        List<Product> products = productsRepository.findAll();  // 추가적인 쿼리나 FetchType을 고려할 수 있음.

        if(products.isEmpty()) {
            throw new ProductNotFoundException();
        }

        return products.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());


    }

    private ProductsResponseDTO.ProductDTO convertToProductDTO(Product product) {
        // DisplayInfo에서 placeName 가져오기
        String placeName = null;

        // Product 객체에서 DisplayInfo를 가져오기 (fetch join, 또는 별도 조회)
        List<DisplayInfo> displayInfoList = product.getDisplayInfo();  // ManyToOne 관계에서 Product와 관련된 DisplayInfo 리스트를 가져옴

        if (displayInfoList != null && !displayInfoList.isEmpty()) {
            placeName = displayInfoList.get(0).getPlaceName();  // 첫 번째 DisplayInfo의 placeName을 사용
        }

        // 썸네일 이미지 정보 가져오기
        ProductImage thumbnailImage = productImageRepository.findFirstByProductAndType(product, "th").orElse(null);

        String productImgUrl = null;
        if (thumbnailImage != null) {
            String fileName = thumbnailImage.getFile().getSaveFileName();
            productImgUrl = "/" + fileName;
        }

        // ProductDTO 반환
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
