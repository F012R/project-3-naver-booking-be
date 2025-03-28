package com.f012r.naverbooking.domain.products.repository;

import com.f012r.naverbooking.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Long countByCategory_Id(Integer categoryId);

    @Query("SELECT p FROM Product p " +
            "LEFT JOIN FETCH p.displayInfo d " +
            "LEFT JOIN FETCH p.productImages pi WHERE pi.type = 'th'")
    List<Product> findAllProductsWithDisplayInfoAndThumbnail();
}