package com.anucodes.Library.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "borrows")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private Date borrowDate;
    private Date returnDate;
    private Boolean returned = false;
}
