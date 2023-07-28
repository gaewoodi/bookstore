package com.gaewoodi.bookstore.service.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    public List<BookDto> getMultiCheck(@RequestParam int bookId) {
//        String testStr = "orange,banana,melon,strawberry";
//        String delimiter = ",";
//
//        System.out.println("테스트 문자열 : " + testStr);
//
//        // split 배열
//        String[] resultArray = testStr.split(delimiter);
//
//        for (int i = 0; i < resultArray.length; i++)
//        {
//            System.out.println("resultArray["+i+"] : " + resultArray[i]);
//        }
        return cartMapper.getCartBook(bookId);
    }


}
