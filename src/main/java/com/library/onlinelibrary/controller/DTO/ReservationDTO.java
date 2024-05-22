package com.library.onlinelibrary.controller.DTO;

import jakarta.validation.constraints.NotNull;

public class ReservationDTO {
    private Long userid;

    @NotNull(message = "Cannot be empty")
    private Long bookid;

    public Long getUserid() {
        return userid;
    }

    public Long getBookid() {
        return bookid;
    }
}
