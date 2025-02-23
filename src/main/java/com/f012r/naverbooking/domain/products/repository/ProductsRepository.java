package com.f012r.naverbooking.domain.products.repository;

import com.f012r.naverbooking.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer>  {
    Long countByCategory_Id(Integer categoryId);
}
