package com.f012r.naverbooking.domain.reservations.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationUserCommentRequestDTO {
    private Integer productId;
    private Integer reservationInfoId;
    private Double score;
    private String comment;

    public void setReservationInfoId(Integer reservationInfoId) {
        this.reservationInfoId = reservationInfoId;
    }
}
