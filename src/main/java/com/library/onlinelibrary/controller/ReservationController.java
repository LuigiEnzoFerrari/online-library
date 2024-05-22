package com.library.onlinelibrary.controller;

import com.library.onlinelibrary.controller.DTO.ReservationDTO;
import com.library.onlinelibrary.model.Book;
import com.library.onlinelibrary.model.Reservation;
import com.library.onlinelibrary.model.Users;
import com.library.onlinelibrary.service.BookService;
import com.library.onlinelibrary.service.ReservationService;
import com.library.onlinelibrary.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public ReservationController(
            ReservationService reservationService,
            BookService bookService,
            UserService userService

                                 ) {
        this.reservationService = reservationService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<Reservation> addReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        System.out.println(reservationDTO);
        Optional<Book> optBook = bookService.getBookById(reservationDTO.getBookid());
        if (optBook.isPresent() == false) {
            return ResponseEntity.notFound().build();
        }

        Book book = optBook.get();
        book.removeStock();
        bookService.updateBook(book);

        Optional<Users> user = userService.getUserById(reservationDTO.getUserid());
        if (user.isPresent() == false) {
            return ResponseEntity.notFound().build();
        }
        Reservation reservation = new Reservation();

        reservation.setBook(book);
        reservation.setUser(user.get());
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }
}
