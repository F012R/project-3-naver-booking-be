package com.f012r.naverbooking.domain.reservations.controller;

import com.f012r.naverbooking.domain.reservations.dto.ReservationCreateRequest;
import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.dto.ReservationListResponse;
import com.f012r.naverbooking.domain.reservations.dto.UserInfoResponse;
import com.f012r.naverbooking.domain.reservations.service.ReservationCreateService;
import com.f012r.naverbooking.domain.reservations.service.ReservationService;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationCreateService reservationCreateService;

    @GetMapping
    public ResponseEntity<ResponseDTO<?>> getReservations(@RequestParam String email) {

        UserInfoResponse userInfoResponse = reservationService.getUserInfoByEmail(email);

        List<ReservationInfoResponse> reservations = reservationService.getReservationsByEmail(email);

        ReservationListResponse reservationListResponse = ReservationListResponse.builder()
                .user(userInfoResponse)
                .reservations(reservations)
                .build();

        return ResponseEntity.ok(
                new ResponseDTO<>(
                        ResponseCode.SUCCESS,
                        reservationListResponse
                )
        );
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<?>> createReservation(@RequestBody ReservationCreateRequest request) {
        ReservationInfoResponse response = reservationCreateService.createReservation(request);
        return ResponseEntity.ok(
                new ResponseDTO<>(
                        ResponseCode.SUCCESS,
                        response
                )
        );
    }
}
