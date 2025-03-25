package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.ReservationAlreadyCancelledException;
import com.f012r.naverbooking.global.exception.custom.ReservationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationCancelService {

    private final ReservationInfoRepository reservationInfoRepository;

    public void cancelReservation(int reservationInfoId) {

        ReservationInfo reservation = reservationInfoRepository.findById(reservationInfoId)
                .orElseThrow(() -> new ReservationNotFoundException(ResponseCode.ReservationNotFoundException));

        if (reservation.getCancelFlag() == 1) {
            throw new ReservationAlreadyCancelledException(ResponseCode.ReservationAlreadyCancelledException);
        }

        reservation.setCancelFlag(1);
    }
}
