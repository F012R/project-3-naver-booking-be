package com.f012r.naverbooking.domain.products.controller;

import com.f012r.naverbooking.domain.products.dto.ProductsResponseDTO;
import com.f012r.naverbooking.domain.products.dto.ProductsInfoResponseDTO;
import com.f012r.naverbooking.domain.products.service.ProductsInfoService;
import com.f012r.naverbooking.domain.products.service.ProductsService;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;
    private final ProductsInfoService productsInfoService;

    public ProductsController(ProductsService productsService, ProductsInfoService productsInfoService) {
        this.productsService = productsService;
        this.productsInfoService = productsInfoService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllProducts() {
        List<ProductsResponseDTO.ProductDTO> productDTOs = productsService.getAllProducts();
        int totalCount = productDTOs.size();

        ProductsResponseDTO responseDTO = ProductsResponseDTO.builder()
                .totalCount(totalCount)
                .items(productDTOs)
                .build();

        ResponseDTO<ProductsResponseDTO> customResponse = new ResponseDTO<>(ResponseCode.SUCCESS, responseDTO);

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getStatus().value())
                .body(customResponse);
    }

    @GetMapping("/{displayInfoId}")
    public ResponseEntity<ResponseDTO> getProductInfo(@PathVariable Integer displayInfoId) {
        ProductsInfoResponseDTO productInfo = productsInfoService.getProductInfo(displayInfoId);

        ResponseDTO<ProductsInfoResponseDTO> responseDTO = new ResponseDTO<>(ResponseCode.SUCCESS, productInfo);

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getStatus().value())
                .body(responseDTO);
    }
}
