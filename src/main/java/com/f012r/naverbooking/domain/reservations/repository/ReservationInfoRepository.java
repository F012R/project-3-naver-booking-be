package com.f012r.naverbooking.domain.reservations.repository;

import com.f012r.naverbooking.domain.reservations.entity.ReservationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationInfoRepository extends JpaRepository<ReservationInfo, Integer> {

    List<ReservationInfo> findByReservationEmail(String reservationEmail);
}
