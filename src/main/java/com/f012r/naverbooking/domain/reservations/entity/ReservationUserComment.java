package com.f012r.naverbooking.domain.reservations.entity;

import com.f012r.naverbooking.domain.products.entity.Product;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservation_user_comment")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReservationUserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_info_id", nullable = false)
    private ReservationInfo reservationInfo;

    @Column(name = "score", nullable = false)
    private Double score;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
        this.modifyDate = this.createDate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifyDate = LocalDateTime.now();
    }
}
