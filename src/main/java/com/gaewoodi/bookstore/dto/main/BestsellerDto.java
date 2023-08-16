package com.gaewoodi.bookstore.dto.main;


import lombok.Data;

@Data
public class BestsellerDto {
    private int bookId;
    private String bookName;
    private String bookSubname;
    private int bookMz;
    private int bookTrend;
    private int bookMedia;
    private String bookImg;
}
