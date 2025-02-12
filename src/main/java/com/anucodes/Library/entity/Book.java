package com.anucodes.Library.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String author;
    private String genre;
    @Column(nullable = false, unique = true)
    private String Isbn;
    private Date publishedDate;
    private Integer totalCopies;
    private Integer availableCopies;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Borrow> borrowing;

    public Book(String title, String author, String genre, String isbn, Date publishedDate, Integer totalCopies, Integer availableCopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        Isbn = isbn;
        this.publishedDate = publishedDate;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public List<Borrow> getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(List<Borrow> borrowing) {
        this.borrowing = borrowing;
    }
}
