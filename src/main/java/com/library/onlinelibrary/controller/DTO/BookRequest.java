package com.library.onlinelibrary.controller.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class BookRequest {

    @NotBlank(message = "Cannot be empty")
    private String title;

    @NotBlank(message = "Cannot be empty")
    private String author;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
