package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.dto.UserInfoResponse;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import com.f012r.naverbooking.global.exception.custom.EmptyEmailException;
import com.f012r.naverbooking.global.exception.custom.InvalidEmailException;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.util.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

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

        if (reservations.isEmpty()) {
            return null;
        }

        ReservationInfo firstReservation = reservations.get(0);

        return UserInfoResponse.builder()
                .reservationName(firstReservation.getReservationName())
                .reservationTel(firstReservation.getReservationTel())
                .reservationEmail(firstReservation.getReservationEmail())
                .build();
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new EmptyEmailException(ResponseCode.EmptyEmailException);
        } else if (!EmailValidator.isValid(email)) {
            throw new InvalidEmailException(ResponseCode.InvalidEmailException);
        }
    }
}
