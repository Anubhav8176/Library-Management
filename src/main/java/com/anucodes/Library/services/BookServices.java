package com.anucodes.Library.services;


import com.anucodes.Library.entity.Book;
import com.anucodes.Library.model.BookDto;
import com.anucodes.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    //Add New Book
    public Boolean   addNewBook(BookDto bookDto){
        if (Objects.equals(bookDto.Isbn(), "")){
            return false;
        }
        try{
            Book book = new Book(
                    bookDto.title(),
                    bookDto.author(),
                    bookDto.genre(),
                    bookDto.Isbn(),
                    bookDto.publishedDate(),
                    bookDto.totalCopies(),
                    bookDto.availableCopies()
            );

            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Delete the book
    public Boolean deleteBook(String isbn){
        try{
            return bookRepository.deleteBookByIsbn(isbn);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //Get all the books
    public List<BookDto> getAllBooks(){
        try{
           List<Book> books = bookRepository.findAll();
           return books.stream()
                   .map(book->
                           new BookDto(
                                   book.getTitle(),
                                   book.getAuthor(),
                                   book.getGenre(),
                                   book.getIsbn(),
                                   book.getPublishedDate(),
                                   book.getTotalCopies(),
                                   book.getAvailableCopies()
                           )
                   ).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    //Get all books by the author
    public List<BookDto> getAllBooksByAuthor(String author){
        try{
            List<Book> booksBy = bookRepository.findAllByAuthor(author);

            return booksBy.stream()
                    .map(book->
                            new BookDto(
                                    book.getTitle(),
                                    book.getAuthor(),
                                    book.getGenre(),
                                    book.getIsbn(),
                                    book.getPublishedDate(),
                                    book.getTotalCopies(),
                                    book.getAvailableCopies()
                            )
                    ).collect(Collectors.toList() );
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
