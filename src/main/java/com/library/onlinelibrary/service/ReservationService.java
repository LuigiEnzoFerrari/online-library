package com.library.onlinelibrary.service;

import com.library.onlinelibrary.model.Reservation;
import com.library.onlinelibrary.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
