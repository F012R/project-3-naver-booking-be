package com.f012r.naverbooking.domain.categories.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CategoriesResponseDTO {

    private int totalCount;
    private List<CategoryDTO> items;

    @Getter
    @Builder
    public static class CategoryDTO {
        private int id;
        private String name;
        private int count;
    }
}
