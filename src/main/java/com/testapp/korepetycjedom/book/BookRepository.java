package com.testapp.korepetycjedom.book;

import com.testapp.korepetycjedom.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    Long deleteBookById(Long id);
}
