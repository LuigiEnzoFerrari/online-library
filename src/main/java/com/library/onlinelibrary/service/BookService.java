package com.library.onlinelibrary.service;

import com.library.onlinelibrary.controller.DTO.BookRequest;
import com.library.onlinelibrary.model.Book;
import com.library.onlinelibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setAuthor(bookRequest.getAuthor());
        book.setTitle(bookRequest.getTitle());
        book.setStock(1);
        book.setAvailable(true);
        bookRepository.save(book);
        return book;
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
