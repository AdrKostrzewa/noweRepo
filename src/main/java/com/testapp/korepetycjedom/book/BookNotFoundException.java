package com.testapp.korepetycjedom.book;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(Long id) {
        super(String.format("Book %d doesn't exist!", id));
    }
}
