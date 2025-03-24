package com.f012r.naverbooking.domain.products.controller;

import com.f012r.naverbooking.domain.products.dto.ProductsResponseDTO;
import com.f012r.naverbooking.domain.products.service.ProductsService;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
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
}
