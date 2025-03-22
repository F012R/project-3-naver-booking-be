package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import com.f012r.naverbooking.global.exception.custom.InvalidEmailException;
import com.f012r.naverbooking.global.common.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationInfoRepository reservationInfoRepository;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    public List<ReservationInfoResponse> getReservationsByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException(ResponseCode.InvalidEmailException);
        }

        if (!emailPattern.matcher(email).matches()) {
            throw new InvalidEmailException(ResponseCode.InvalidEmailException);
        }

        List<ReservationInfo> reservations = reservationInfoRepository.findByReservationEmail(email);
        return reservations.stream()
                .map(ReservationInfoResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
