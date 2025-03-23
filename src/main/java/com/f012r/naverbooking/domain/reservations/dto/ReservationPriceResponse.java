package com.f012r.naverbooking.domain.reservations.dto;

import com.f012r.naverbooking.domain.reservations.entity.ReservationInfoPrice;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationPriceResponse {

    private Integer reservationInfoPriceId;
    private Integer productPriceId;
    private Integer count;

    public static ReservationPriceResponse fromEntity(ReservationInfoPrice entity) {
        return ReservationPriceResponse.builder()
                .reservationInfoPriceId(entity.getId())
                .productPriceId(entity.getProductPriceId())
                .count(entity.getCount())
                .build();
    }
}
