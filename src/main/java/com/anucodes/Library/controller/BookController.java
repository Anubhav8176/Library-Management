package com.anucodes.Library.controller;


import com.anucodes.Library.model.BookDto;
import com.anucodes.Library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
