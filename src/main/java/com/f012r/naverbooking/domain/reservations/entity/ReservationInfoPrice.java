package com.f012r.naverbooking.domain.reservations.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation_info_price")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReservationInfoPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_price_id", nullable = false)
    private Integer productPriceId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id", nullable = false)
    private ReservationInfo reservationInfo;
}
