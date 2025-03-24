package com.f012r.naverbooking.domain.reservations.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ReservationCreateRequest {
    private Integer productId;
    private Integer displayInfoId;
    private String reservationName;
    private String reservationTel;
    private String reservationEmail;
    private LocalDateTime reservationDate;
    private List<PriceRequest> prices;

    @Getter
    @NoArgsConstructor
    public static class PriceRequest {
        private Integer productPriceId;
        private Integer count;
    }
}