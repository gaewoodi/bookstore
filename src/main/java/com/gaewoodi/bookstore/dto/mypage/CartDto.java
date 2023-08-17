package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.Year;
import java.util.Date;

@Data
public class CartDto {
    private int cartId;
    private int regId;
    private int bookId;
    private String bookCode;
    private String bookName;
    private int bookStock;
    private String author;
    private String publisher;
    private Year publicationDate;
    private String category;
    private String price;
    private int visit;
    private int quantity;
}
