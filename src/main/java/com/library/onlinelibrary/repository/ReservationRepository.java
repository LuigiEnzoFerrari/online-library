package com.library.onlinelibrary.repository;

import com.library.onlinelibrary.model.Reservation;
import com.library.onlinelibrary.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByBookId(Long aLong);
    List<Reservation> findByUserId(Long aLong);
}
