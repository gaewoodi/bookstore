package com.gaewoodi.bookstore.dto.purchase;

import lombok.Data;

import java.time.Year;

@Data
public class CartDto {
    private int cartId;
    private String bookCode;
    private String bookName;
    private int bookCount;
    private String author;
    private String publisher;
    private Year publicationDate;
    private String category;
    private String price;
}

