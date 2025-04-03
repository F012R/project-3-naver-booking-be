package com.f012r.naverbooking.domain.reservations.repository;

import com.f012r.naverbooking.domain.reservations.entity.ReservationUserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationUserCommentRepository extends JpaRepository<ReservationUserComment, Integer> {
}
