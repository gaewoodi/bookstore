package com.gaewoodi.bookstore.dto.mypage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PurchaseDto {
    //주문번호
    private int purchaseId;
    //책 id
    private int bookId;
    //주문아이디
    private int regId;
    // 주문일자
    private LocalDateTime purchaseDate;
    // 주문금액
    private int price;
    // 주문수량
    private int quantity;
    //총 주문금액
    private int totalPrice;
    // 주문 상태 : 구매/주문취소
    private String purchaseStatus;
    // 결제 완료일
    private LocalDateTime paymentEndDate;
    //book_mst 재고수
    private String bookStock;
    // -주문수량
    private int minusQuantity;
    // +주문수량
    private int plusQuantity;

    private String bookName;



}
