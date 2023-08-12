package com.gaewoodi.bookstore.service.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class SelectService {

    @Autowired
    private CartMapper cartMapper;

    public List<BookDto> getCartBookList(int[] bookId) {
        Map<String, Object> map = new HashMap<>();

        String checkResult = "";
        String select = " " + "book_id = ";
        String marks = "'";

        String orSelect = "OR" + " ";

        int count = 1;

        StringBuilder sb = new StringBuilder();

        if(bookId.length == count) {
            for (int i = 0; i < bookId.length; i++) {
                checkResult = select + marks + bookId[i] + marks;
            }

       }else {
            String result1 = "";

            for (int i = 0; i < 1; i++) {
                result1 = select + marks + bookId[i] + marks;
                checkResult = result1;
                System.out.println("i값: " + i);
            }

            //j = OR book_id...를 반복 시키기 위해 필요
            for (int j = 1; j < bookId.length; j++) {
                String andSelect = "";

                for(int k = 2; k < bookId.length; k++) {
                    andSelect = "OR book_id = '" + bookId[k] + "'";
                    System.out.println("k값 : " + k);
                    sb.append(andSelect);

                    checkResult = result1 + andSelect.repeat(j);

                    System.out.println("-----------------------------------");
//                    System.out.println("**1번째 값 : " + checkResult);
                }
                System.out.println("j값: " + andSelect.repeat(j));
                checkResult = result1 + andSelect.repeat(j);

            }


//            System.out.println("2번째 값 : " + checkResult);
            System.out.println("DB 값: " + "SELECT * FROM book_mst WHERE"  +checkResult);
        }

            map.put("checkResult", checkResult);

        return cartMapper.getCartBookList(map);
    }

    public List<BookDto> getCartBook(List<String> checkArray) {
        Map<String, Object> map = new HashMap<>();

        System.out.println("service에서 checkArray:" + checkArray);

        return cartMapper.getCartBookList(map);
    }

}
