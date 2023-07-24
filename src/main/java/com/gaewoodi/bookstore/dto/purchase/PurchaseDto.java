package com.gaewoodi.bookstore.dto.purchase;

import lombok.Data;

import java.time.Year;

@Data
public class PurchaseDto {
    private int bookId;
    private String bookCode;
    private String bookName;
    private String author;
    private String publisher;
    private Year publicationDate;
    private String category;
    private String price;
    private int bookCount;
    private int purchaseBookCount;

}
