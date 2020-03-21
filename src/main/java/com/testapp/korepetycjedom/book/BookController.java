package com.testapp.korepetycjedom.book;

import com.testapp.korepetycjedom.book.conventer.BookConverter;
import com.testapp.korepetycjedom.book.model.Book;
import com.testapp.korepetycjedom.book.model.dto.BookResponseDTO;
import com.testapp.korepetycjedom.exception.ServerException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//http:localhost:8080 /books
@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @GetMapping
    public List<BookResponseDTO> getALlBooks() {
        return bookConverter.convertToBookDTO(bookService.findAll());
    }

    @GetMapping(value = "/{id}")
    public BookResponseDTO findBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookConverter.convertToBookDTO(bookService.findBookById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping(value = "/{id}")
    public Book deleteBook(@PathVariable Long id) throws BookNotFoundException, ServerException {
        return bookService.deleteBook(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) throws BookNotFoundException {
        return bookService.updateBook(id, book);
    }
}
