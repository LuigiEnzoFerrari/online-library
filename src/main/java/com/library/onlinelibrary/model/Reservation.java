package com.library.onlinelibrary.model;


import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "bookid", nullable = false)
    private Book book;

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
