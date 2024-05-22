package com.library.onlinelibrary.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewDTO {

    private Long userid;

    @NotNull(message = "Cannot be empty")
    private Long bookid;

    @NotNull(message = "Cannot be empty")
    private String review;

    public Long getBookid() {
        return bookid;
    }

    public String getReview() {
        return review;
    }

    public Long getUserid() {
        return userid;
    }
}
