package com.f012r.naverbooking.domain.reservations.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReservationListResponse {

    private UserInfoResponse user;
    private List<ReservationInfoResponse> reservations;

}
