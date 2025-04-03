package com.f012r.naverbooking.domain.reservations.service;

import com.f012r.naverbooking.domain.reservations.dto.ReservationUserCommentRequestDTO;
import com.f012r.naverbooking.domain.reservations.dto.ReservationUserCommentResponseDTO;
import com.f012r.naverbooking.domain.reservations.entity.ReservationUserComment;
import com.f012r.naverbooking.domain.reservations.repository.ReservationUserCommentRepository;
import com.f012r.naverbooking.domain.products.entity.Product;
import com.f012r.naverbooking.domain.products.repository.ProductsRepository;
import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import com.f012r.naverbooking.domain.reservations.repository.ReservationInfoRepository;
import com.f012r.naverbooking.global.common.ResponseCode;
import com.f012r.naverbooking.global.exception.custom.EmptyCommentException;
import com.f012r.naverbooking.global.exception.custom.InvalidDisplayInfoIdException;
import com.f012r.naverbooking.global.exception.custom.InvalidScoreException;
import com.f012r.naverbooking.global.exception.custom.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ReservationUserCommentService {

    private final ReservationUserCommentRepository reservationUserCommentRepository;
    private final ProductsRepository productRepository;
    private final ReservationInfoRepository reservationInfoRepository;

    @Autowired
    public ReservationUserCommentService(ReservationUserCommentRepository reservationUserCommentRepository,
                                         ProductsRepository productRepository,
                                         ReservationInfoRepository reservationInfoRepository) {
        this.reservationUserCommentRepository = reservationUserCommentRepository;
        this.productRepository = productRepository;
        this.reservationInfoRepository = reservationInfoRepository;
    }

    @Transactional
    public ReservationUserCommentResponseDTO createComment(ReservationUserCommentRequestDTO requestDTO) {
        Product product = productRepository.findById(requestDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException(ResponseCode.ProductNotFoundException));

        ReservationInfo reservationInfo = reservationInfoRepository.findById(requestDTO.getReservationInfoId())
                .orElseThrow(() -> new InvalidDisplayInfoIdException(ResponseCode.InvalidDisplayInfoIdException));

        if (requestDTO.getScore() < 0 || requestDTO.getScore() > 5) {
            throw new InvalidScoreException(ResponseCode.InvalidScoreException);
        }

        if (requestDTO.getComment() == null || requestDTO.getComment().trim().isEmpty()) {
            throw new EmptyCommentException(ResponseCode.EmptyCommentException);
        }


        ReservationUserComment comment = ReservationUserComment.builder()
                .product(product)
                .reservationInfo(reservationInfo)
                .score(requestDTO.getScore())
                .comment(requestDTO.getComment())
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .build();

        ReservationUserComment savedComment = reservationUserCommentRepository.save(comment);

        return ReservationUserCommentResponseDTO.fromEntity(savedComment);
    }
}
