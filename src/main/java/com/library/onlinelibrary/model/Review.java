package com.library.onlinelibrary.model;


import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "bookid", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String review;

    public Long getId() {
        return id;
    }

    public Users getUserid() {
        return user;
    }

    public Book getBookid() {
        return book;
    }

    public String getReview() {
        return review;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
