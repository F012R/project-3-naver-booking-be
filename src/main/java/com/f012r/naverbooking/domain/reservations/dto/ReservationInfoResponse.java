package com.f012r.naverbooking.domain.reservations.dto;

import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ReservationInfoResponse {

    private Integer reservationId;
    private Integer productId;
    private Integer displayInfoId;
    private LocalDateTime reservationDate;
    private Integer cancelFlag;
    private List<ReservationPriceResponse> prices;

    public static ReservationInfoResponse fromEntity(ReservationInfo entity) {
        return ReservationInfoResponse.builder()
                .reservationId(entity.getId())
                .productId(entity.getProductId())
                .displayInfoId(entity.getDisplayInfoId())
                .reservationDate(entity.getReservationDate())
                .cancelFlag(entity.getCancelFlag())
                .prices(entity.getPrices().stream().map(ReservationPriceResponse::fromEntity).toList())
                .build();
    }
}
