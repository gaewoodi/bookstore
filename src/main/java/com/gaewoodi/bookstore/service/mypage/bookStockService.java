//package com.gaewoodi.bookstore.service.mypage;
//
//import com.gaewoodi.bookstore.dto.BookDto;
//import com.gaewoodi.bookstore.dto.mypage.PurchaseDto;
//import com.gaewoodi.bookstore.mappers.mypage.BookMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class bookStockService {
//    @Autowired
//    private BookMapper bookMapper;
//
//    PurchaseDto purchaseDto = new PurchaseDto();
//
//    public PurchaseDto bookStockCalculator(int quantity) {
//        int bookStock = bookMapper.getBookStock(purchaseDto.getBookId());
//
//        int minusQuantity = bookStock - 1;
//        int plusQuantity = bookStock + 1;
//
//        purchaseDto.setMinusQuantity(minusQuantity);
//        purchaseDto.setMinusQuantity(plusQuantity);
//
//        return purchaseDto;
//    }
//
//    public List<BookDto> getBookQuantity(int quantity) {
//
//        return
//    }
//}
