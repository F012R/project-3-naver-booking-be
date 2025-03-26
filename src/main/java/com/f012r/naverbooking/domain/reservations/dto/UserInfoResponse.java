package com.f012r.naverbooking.domain.reservations.dto;

import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private String reservationName;
    private String reservationTel;
    private String reservationEmail;

}
