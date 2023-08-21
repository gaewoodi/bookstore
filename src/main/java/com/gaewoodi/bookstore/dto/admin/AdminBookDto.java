package com.gaewoodi.bookstore.dto.admin;

import lombok.Data;

import java.time.Year;

@Data
public class AdminBookDto {

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

    private int imageId;
    private String saveName;
    private String originName;
    private Long size;
}
