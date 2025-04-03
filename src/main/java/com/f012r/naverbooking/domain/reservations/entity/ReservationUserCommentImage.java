package com.f012r.naverbooking.domain.reservations.entity;

import com.f012r.naverbooking.domain.products.entity.FileInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation_user_comment_image")
@Getter
@Setter
@NoArgsConstructor
public class ReservationUserCommentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id", nullable = false)
    private ReservationInfo reservationInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_user_comment_id", nullable = false)
    private ReservationUserComment reservationUserComment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private FileInfo fileInfo;
}
