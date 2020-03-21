package com.testapp.korepetycjedom.book;

import com.testapp.korepetycjedom.book.model.Book;
import com.testapp.korepetycjedom.exception.ServerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book deleteBook(Long id) throws BookNotFoundException, ServerException {
        Optional<Book> foundBook = findBookById(id);
        if (foundBook.isPresent()) {
            try {
                bookRepository.deleteBookById(id);
            } catch (Exception e) {
                throw new ServerException(String.format("Something went wrong during removing a book by id: %d. Exception message: %s", id, e.getMessage()));
            }
        } else {
            throw new BookNotFoundException(id);
        }
       return foundBook.get();
    }

    public Book updateBook(Long id, Book book) throws BookNotFoundException {
        Book foundBook;
        try {
            foundBook = bookRepository.getOne(id);
        } catch (EntityNotFoundException e) {
            throw new BookNotFoundException(id);
        }
        foundBook.setTitle(book.getTitle());
        foundBook.setIsbn(book.getIsbn());
        return bookRepository.save(foundBook);
    }
}
