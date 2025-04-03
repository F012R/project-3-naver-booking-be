package com.f012r.naverbooking.domain.reservations.dto;

import com.f012r.naverbooking.domain.reservations.entity.ReservationUserComment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class ReservationUserCommentResponseDTO {
    private Integer id;
    private Integer productId;
    private Integer reservationInfoId;
    private Double score;
    private String comment;
    private String createDate;
    private String modifyDate;

    public static ReservationUserCommentResponseDTO fromEntity(ReservationUserComment entity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return ReservationUserCommentResponseDTO.builder()
                .id(entity.getId())
                .productId(entity.getProduct().getId())
                .reservationInfoId(entity.getReservationInfo().getId())
                .score(entity.getScore())
                .comment(entity.getComment())
                .createDate(entity.getCreateDate().format(formatter))
                .modifyDate(entity.getModifyDate().format(formatter))
                .build();
    }
}
