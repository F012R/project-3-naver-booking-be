package com.f012r.naverbooking.domain.promotions.repository;

import com.f012r.naverbooking.domain.promotions.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionsRepository  extends JpaRepository<Promotion, Integer> {
}
