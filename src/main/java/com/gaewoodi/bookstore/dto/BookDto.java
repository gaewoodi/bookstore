package com.gaewoodi.bookstore.dto;

import lombok.Data;
import java.time.Year;

@Data
public class BookDto {
    private int bookId;
    private String bookCode;
    private String bookName;
    // 재고수
    private String bookStock;
    private String author;
    private String publisher;
    private Year publicationDate;
    private String category;
    private String price;
    private int visit;
    private int likeCount;
}
