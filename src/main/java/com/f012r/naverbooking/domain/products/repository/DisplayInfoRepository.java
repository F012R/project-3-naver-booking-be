package com.f012r.naverbooking.domain.products.repository;

import com.f012r.naverbooking.domain.products.entity.DisplayInfo;
import com.f012r.naverbooking.domain.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisplayInfoRepository extends JpaRepository<DisplayInfo, Integer> {
    Optional<DisplayInfo> findByProduct(Product product);
}
