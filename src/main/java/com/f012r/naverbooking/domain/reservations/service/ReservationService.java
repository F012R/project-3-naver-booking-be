package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationInfoRepository reservationInfoRepository;

    public List<ReservationInfoResponse> getReservationsByEmail(String email) {
        List<ReservationInfo> reservations = reservationInfoRepository.findByReservationEmail(email);

        return reservations.stream()
                .map(ReservationInfoResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
