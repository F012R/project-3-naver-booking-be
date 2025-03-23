package com.f012r.naverbooking.domain.reservations.controller;

import com.f012r.naverbooking.domain.reservations.service.ReservationService;
import com.f012r.naverbooking.global.common.ResponseDTO;
import com.f012r.naverbooking.global.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<ResponseDTO<?>> getReservations(@RequestParam String email) {
        return ResponseEntity.ok(
                new ResponseDTO<>(
                        ResponseCode.SUCCESS,
                        reservationService.getReservationsByEmail(email)
                )
        );
    }
}
