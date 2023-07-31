package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.Year;
import java.util.Date;
import java.util.List;

@Data
public class CartDto {
    private int cartId;
    private String bookCode;
    private Date cartCookieLimit; // 쿠키제한시간(삭제용)
    private String cartCokkieId; // 쿠키 value 값
}

