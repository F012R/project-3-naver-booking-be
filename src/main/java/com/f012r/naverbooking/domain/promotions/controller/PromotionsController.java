package com.f012r.naverbooking.domain.promotions.controller;

import com.f012r.naverbooking.domain.promotions.dto.PromotionsResponseDTO;
import com.f012r.naverbooking.domain.promotions.service.PromotionsService;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/promotions")
public class PromotionsController {

    private final PromotionsService promotionsService;

    @Autowired
    public PromotionsController(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getPromotions() {

        PromotionsResponseDTO promotionsResponseDTO = promotionsService.getPromotions();

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.SUCCESS, promotionsResponseDTO));
    }
}
