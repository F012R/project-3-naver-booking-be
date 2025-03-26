package com.f012r.naverbooking.domain.products.controller;

import com.f012r.naverbooking.domain.products.dto.ProductsInfoResponseDTO;
import com.f012r.naverbooking.domain.products.service.ProductsInfoService;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.common.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsInfoController {

    private final ProductsInfoService productsInfoService;

    public ProductsInfoController(ProductsInfoService productsInfoService) {
        this.productsInfoService = productsInfoService;
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
