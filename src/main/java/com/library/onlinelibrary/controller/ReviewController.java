package com.library.onlinelibrary.controller;

import com.library.onlinelibrary.controller.DTO.ReviewDTO;
import com.library.onlinelibrary.model.Book;
import com.library.onlinelibrary.model.Review;
import com.library.onlinelibrary.model.Users;
import com.library.onlinelibrary.service.BookService;
import com.library.onlinelibrary.service.ReviewService;
import com.library.onlinelibrary.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books/{bookId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public ReviewController(ReviewService reviewService,
                            BookService bookService,
                            UserService userService) {
        this.reviewService = reviewService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<Review>> getReviewByBookId(@PathVariable Long bookId) {
        return ResponseEntity.ok(reviewService.getReviewByBookId(bookId));
    }

    @PostMapping
    ResponseEntity<Review> addReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        Optional<Book> book = bookService.getBookById(reviewDTO.getBookid());
        if (book.isPresent() == false) {
            return ResponseEntity.notFound().build();
        }

        Optional<Users> user = userService.getUserById(reviewDTO.getUserid());
        if (user.isPresent() == false) {
            return ResponseEntity.notFound().build();
        }
        Review review = new Review();
        review.setBook(book.get());
        review.setUser(user.get());
        review.setReview(reviewDTO.getReview());
        return ResponseEntity.ok(reviewService.saveReview(review));
    }
}
