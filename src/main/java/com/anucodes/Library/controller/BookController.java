package com.anucodes.Library.controller;


import com.anucodes.Library.entity.Book;
import com.anucodes.Library.model.BookDto;
import com.anucodes.Library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookDto bookDto) {
        if (bookServices.addNewBook(bookDto)){
            return new ResponseEntity<>("Book added successfully",HttpStatus.OK);
        }
        else {
            throw new RuntimeException("Error adding the book");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllBooks(){
        try{
            List<BookDto> books = bookServices.getAllBooks();
            return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getByAuthor")
    public ResponseEntity getAllByAuthor(@RequestBody String author){
        try{
            List<BookDto> books = bookServices.getAllBooksByAuthor(author);
            return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity deleteBook(@RequestBody String isbn){
        try {
            return new ResponseEntity<>("Book deleted successfully!", HttpStatus.OK);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
