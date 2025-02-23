package com.f012r.naverbooking.domain.categories.controller;

import com.f012r.naverbooking.domain.categories.dto.CategoriesResponseDTO;
import com.f012r.naverbooking.domain.categories.service.CategoriesService;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.exception.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getCategories() {

        CategoriesResponseDTO categoriesResponseDTO = categoriesService.getCategories();

        return ResponseEntity
                .status(ResponseCode.SUCCESS.getStatus().value())
                .body(new ResponseDTO<>(ResponseCode.SUCCESS, categoriesResponseDTO));
    }
}
