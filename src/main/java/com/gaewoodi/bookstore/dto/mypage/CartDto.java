package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.Year;
import java.util.Date;

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
    private Date cartCookieLimit; // 쿠키제한시간(삭제용)
    private String cartCokkieId; // 쿠키 value 값
}

