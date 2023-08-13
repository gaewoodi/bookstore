//package com.gaewoodi.bookstore.service.mypage;
//
//import com.gaewoodi.bookstore.dto.BookDto;
//import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class SelectService {
//
//
//    @Autowired
//    private CartMapper cartMapper;
//
//    public List<BookDto> getCartBookList(String result) {
//        Map<String, Object> map = new HashMap<>();
//
//
//        String checkResult = "";
//        String orCheckResult = "";
//
//        String[] splitResult = result.toString().split(" ");
//
//        for(int i = 0; i < splitResult.length -2; i++) {
//            checkResult = "'" + splitResult[i] + "'";
//
//            map.put("checkResult", checkResult);
//
//            System.out.println("checkResult: " + checkResult);
//
//            for(int j = 1; j < splitResult.length; j++) {
//                orCheckResult = "OR bookId = " + "'" + splitResult[j] + "'";
//                map.put("orCheckResult", orCheckResult);
//
//                System.out.println("orCheckResult: " + orCheckResult);
//
//
//            }
//
//
//        }
//
//
//
//        return cartMapper.getCartBookList(map);
//    }
//
//}
