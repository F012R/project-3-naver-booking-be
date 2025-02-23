package com.f012r.naverbooking.domain.categories.repository;

import com.f012r.naverbooking.domain.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
