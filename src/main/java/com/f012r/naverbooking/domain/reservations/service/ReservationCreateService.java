package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationCreateRequest;
import com.f012r.naverbooking.domain.reservations.dto.ReservationInfoResponse;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfoPrice;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.InvalidReservationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.f012r.naverbooking.global.util.EmailValidator.validateEmail;

@Service
@RequiredArgsConstructor
public class ReservationCreateService {

    private final ReservationInfoRepository reservationInfoRepository;

    @Transactional
    public ReservationInfoResponse createReservation(ReservationCreateRequest request) {

        validateReservationRequest(request);

        ReservationInfo reservationInfo = ReservationInfo.builder()
                .productId(request.getProductId())
                .displayInfoId(request.getDisplayInfoId())
                .reservationName(request.getReservationName())
                .reservationTel(request.getReservationTel())
                .reservationEmail(request.getReservationEmail())
                .reservationDate(request.getReservationDate())
                .cancelFlag(0)
                .build();

        ReservationInfo savedReservation = reservationInfoRepository.save(reservationInfo);

        List<ReservationInfoPrice> prices = new ArrayList<>();
        for (ReservationCreateRequest.PriceRequest priceRequest : request.getPrices()) {
            ReservationInfoPrice price = ReservationInfoPrice.builder()
                    .productPriceId(priceRequest.getProductPriceId())
                    .count(priceRequest.getCount())
                    .reservationInfo(savedReservation)
                    .build();
            prices.add(price);
        }

        savedReservation.setPrices(prices);
        reservationInfoRepository.save(savedReservation);

        return ReservationInfoResponse.fromEntity(savedReservation);
    }

    private void validateReservationRequest(ReservationCreateRequest request) {
        validateEmail(request.getReservationEmail());

        if (request.getReservationName() == null || request.getReservationName().isEmpty() ||
                request.getReservationTel() == null || request.getReservationTel().isEmpty() ||
                request.getReservationEmail() == null || request.getReservationEmail().isEmpty()) {
            throw new InvalidReservationException(ResponseCode.InvalidReservationRequest);
        }
    }
}