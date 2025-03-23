package com.f012r.naverbooking.domain.products.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_price")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "price_type_name", nullable = false, length = 25)
    private String priceTypeName; // 성인(A), 청소년(Y), 유아(B), 셋트(S), 장애인(D), 지역주민(C), 어얼리버드(E)

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "discount_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal discountRate; // 할인율 (DECIMAL(5,2))

    @Column(name = "create_date", updatable = false)
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

}
