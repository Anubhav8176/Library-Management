package com.anucodes.Library.repository;

import com.anucodes.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Boolean deleteBookByIsbn(String isbn);
    List<Book> findAllByAuthor(String author);
}
