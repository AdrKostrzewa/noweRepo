package com.testapp.korepetycjedom.book;

import com.testapp.korepetycjedom.book.model.Book;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//http:localhost:8080 /books
@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // sluzy do pobierania danych
    @GetMapping
    public List<Book> getALlBooks() {
        return bookService.findAll();
    }
    // /books/
    @GetMapping(value = "/{id}")
    public Book findBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findBookById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    // sluzy do dodawania danych
    @PostMapping
    public Book addBook(@RequestBody Book book) {
//        Book b = Book.builder().isbn("isbn").title("title").build();
        return bookService.addBook(book);
    }
}
