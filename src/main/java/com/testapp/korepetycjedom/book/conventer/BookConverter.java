package com.testapp.korepetycjedom.book.conventer;

import com.testapp.korepetycjedom.book.model.Book;
import com.testapp.korepetycjedom.book.model.dto.BookResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookConverter {

    private final ModelMapper modelMapper;

    public List<BookResponseDTO> convertToBookDTO(List<Book> books){
        return books.stream().map(this::convertToBookDTO).collect(Collectors.toList());
    }

    public BookResponseDTO convertToBookDTO(Book book) {
        return modelMapper.map(book, BookResponseDTO.class);
    }
}
