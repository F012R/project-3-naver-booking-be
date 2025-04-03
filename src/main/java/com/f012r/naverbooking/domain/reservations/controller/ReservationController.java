package com.f012r.naverbooking.domain.reservations.controller;

import com.f012r.naverbooking.domain.reservations.dto.ReservationCreateRequest;
import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.dto.ReservationListResponse;
import com.f012r.naverbooking.domain.reservations.dto.UserInfoResponse;
import com.f012r.naverbooking.domain.reservations.dto.ReservationUserCommentRequestDTO;
import com.f012r.naverbooking.domain.reservations.dto.ReservationUserCommentResponseDTO;
import com.f012r.naverbooking.domain.reservations.service.ReservationUserCommentService;
import com.f012r.naverbooking.domain.reservations.service.ReservationCreateService;
import com.f012r.naverbooking.domain.reservations.service.ReservationInfoService;
import com.f012r.naverbooking.domain.reservations.service.ReservationCancelService;


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

    private final ReservationInfoService reservationService;
    private final ReservationCreateService reservationCreateService;
    private final ReservationCancelService reservationCancelService;
    private final ReservationUserCommentService reservationUserCommentService;

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

    @DeleteMapping("/{reservationInfoId}")
    public ResponseEntity<ResponseDTO<Void>> cancelReservation(@PathVariable int reservationInfoId) {
        reservationCancelService.cancelReservation(reservationInfoId);
        return ResponseEntity.ok(new ResponseDTO<>(ResponseCode.SUCCESS, null));
    }

    @PostMapping("/{reservationInfoId}/comments")
    public ResponseEntity<ResponseDTO<?>> createComment(
            @PathVariable("reservationInfoId") Integer reservationInfoId,
            @RequestBody ReservationUserCommentRequestDTO requestDTO) {

        requestDTO.setReservationInfoId(reservationInfoId);
        ReservationUserCommentResponseDTO responseDTO = reservationUserCommentService.createComment(requestDTO);

        return ResponseEntity.ok(
                new ResponseDTO<>(
                        ResponseCode.SUCCESS,
                        responseDTO
                )
        );
    }

}
