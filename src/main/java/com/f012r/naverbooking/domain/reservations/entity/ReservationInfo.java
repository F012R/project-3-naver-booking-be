package com.f012r.naverbooking.domain.reservations.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservation_info")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReservationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "display_info_id", nullable = false)
    private Integer displayInfoId;

    @Column(name = "reservation_name", nullable = false)
    private String reservationName;

    @Column(name = "reservation_tel", nullable = false)
    private String reservationTel;

    @Column(name = "reservation_email", nullable = false)
    private String reservationEmail;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @Column(name = "cancel_flag", nullable = false)
    private Integer cancelFlag;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "reservationInfo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ReservationInfoPrice> prices;

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