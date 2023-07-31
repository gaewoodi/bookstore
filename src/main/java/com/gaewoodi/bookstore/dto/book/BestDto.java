package com.gaewoodi.bookstore.dto.book;

import lombok.Data;

import java.time.Year;

@Data
public class BestDto {
private int  bookId;
private String bookCode;
private String bookName;
private int bookCount;
private String author;
private String publisher;
private Year publicationDate;
private String category;
private String price;
}
