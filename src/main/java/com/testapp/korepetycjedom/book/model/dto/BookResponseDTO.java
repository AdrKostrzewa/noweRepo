package com.testapp.korepetycjedom.book.model.dto;

import lombok.Data;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String isbn;
}
