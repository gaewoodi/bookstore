package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

@Data
public class CartDto {
    private int cartId;
    private int regId;
    private int bookId;
    private LocalDateTime createDate;
}
