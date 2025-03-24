package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.dto.UserInfoResponse;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.f012r.naverbooking.global.util.EmailValidator.validateEmail;

@Service
@RequiredArgsConstructor
public class ReservationInfoService {

    private final ReservationInfoRepository reservationInfoRepository;

    public List<ReservationInfoResponse> getReservationsByEmail(String email) {

        validateEmail(email);

        List<ReservationInfo> reservations = reservationInfoRepository.findByReservationEmail(email);

        return reservations.stream()
                .map(ReservationInfoResponse::fromEntity)
                .toList();
    }

    public UserInfoResponse getUserInfoByEmail(String email) {

        validateEmail(email);

        List<ReservationInfo> reservations = reservationInfoRepository.findByReservationEmail(email);

        String reservationName = "";
        String reservationTel = "";

        if (!reservations.isEmpty()) {
            ReservationInfo firstReservation = reservations.get(0);
            reservationName = firstReservation.getReservationName();
            reservationTel = firstReservation.getReservationTel();
        }

        return UserInfoResponse.builder()
                .reservationName(reservationName)
                .reservationTel(reservationTel)
                .reservationEmail(email)
                .build();
    }

}
