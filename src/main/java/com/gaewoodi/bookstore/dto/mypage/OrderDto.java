package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

@Data
public class OrderDto {
    //주문번호
    private int orderId;
    //주문아이디
    private int userId;
    // 주문일자
    private LocalDateTime orderDate;
    // 주문금액
    private int price;
    // 주문수량
    private int quantity;
    //총 주문금액
    private int totalPrice;
    // 주문 상태 : 구매/주문취소
    private String orderStatus;
    // 결제금액
    private int paymentPrice;
    // 결제 완료일
    private LocalDateTime paymentEndDate;

}
