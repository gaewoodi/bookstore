package com.gaewoodi.bookstore.service.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SelectService {

    @Autowired
    private CartMapper cartMapper;

    public List<BookDto> getCartBookList(int[] bookId) {

        String checkResult = "";
        String select = "book_id = ";
        String marks = "'";
        String andSelect = "OR book_id = ";

        int count = 1;

        if(bookId.length == count) {
            for (int i = 0; i < bookId.length; i++) {
                checkResult = select + marks + bookId[i] + marks;
            }

       }else {

            for (int i = 0; i < bookId.length; i++) {
                andSelect = "OR book_id = '" + bookId[i] + "'";

                for(int j = 0; j < 1; j++) {
                    checkResult = select + marks + bookId[j] + marks + andSelect;
                }
            }

        }
        Map<String, Object> map = new HashMap<>();
        map.put("checkResult", checkResult);

        return cartMapper.getCartBookList(map);
    }

}
