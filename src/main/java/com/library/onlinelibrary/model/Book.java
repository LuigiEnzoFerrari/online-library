package com.library.onlinelibrary.model;


import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Boolean available;

    @Column(nullable = false)
    private Integer stock;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void addStock() {
        this.setStock(this.stock + 1);
    }

    public void removeStock() {
        this.setStock(this.stock - 1);
        if (this.stock == 0) {
            this.setAvailable(false);
        }
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
