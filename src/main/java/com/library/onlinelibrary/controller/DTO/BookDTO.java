package com.library.onlinelibrary.controller.DTO;

import jakarta.validation.constraints.NotBlank;

public class BookDTO {

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
