package com.f012r.naverbooking.domain.categories.service;

import com.f012r.naverbooking.domain.categories.dto.CategoriesResponseDTO;
import com.f012r.naverbooking.domain.categories.entity.Category;
import com.f012r.naverbooking.domain.categories.repository.CategoriesRepository;
import com.f012r.naverbooking.domain.products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepository;
    private ProductsRepository productsRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository,
                             ProductsRepository productsRepository) {
        this.categoriesRepository = categoriesRepository;
        this.productsRepository = productsRepository;
    }

    public CategoriesResponseDTO getCategories() {
        List<CategoriesResponseDTO.CategoryDTO> categoryDTOList = new ArrayList<>();
        List<Category> categories = categoriesRepository.findAll();

        for (Category category : categories) {
            int productsCount = productsRepository.countByCategory_Id(category.getId()).intValue();

            CategoriesResponseDTO.CategoryDTO categoryDTO = CategoriesResponseDTO.CategoryDTO.builder()
                    .id(category.getId())
                    .name(category.getName())
                    .count(productsCount)
                    .build();

            categoryDTOList.add(categoryDTO);
        }

        return CategoriesResponseDTO.builder()
                .totalCount(categories.size())
                .items(categoryDTOList)
                .build();
    }
}
