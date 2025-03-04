package com.f012r.naverbooking.domain.products.repository;

import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    Optional<ProductImage> findFirstByProductAndType(Product product, String imageType);
}
