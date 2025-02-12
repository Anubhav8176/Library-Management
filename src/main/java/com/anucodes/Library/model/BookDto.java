package com.anucodes.Library.model;

import java.util.Date;

public record BookDto(
        String title,
        String author,
        String genre,
        String Isbn,
        Date publishedDate,
        Integer totalCopies,
        Integer availableCopies
){

}
