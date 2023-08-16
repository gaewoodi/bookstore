package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;


//    @GetMapping("/cart")
//    public String getCart(Model model) {
//        model.addAttribute("book", cartMapper.getCartBookList());
////        model.addAttribute("cart", selectServices.getCartBookList())
//
//        //cart 테이블에 저장된 자료를 select로 읽어 와서 cart.html에 표시하기
//
//        return "mypage/cart";
//    }

    @GetMapping("/cart")
    @ResponseBody
    public String getCart() {

        return "mypage/cart";
    }


    @PostMapping("/cart")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value = "checkboxResult") String result, CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();

        String[] splitResult = result.split(" ");

        for(int i = 0; i < splitResult.length; i++) {
            //System.out.println(splitResult[i]);
            System.out.println(cartMapper.getCartBookList(Integer.parseInt(splitResult[i])));
            map.put("data" + i, cartMapper.getCartBookList(Integer.parseInt(splitResult[i])));
        }

        System.out.println("map: " + map);
        System.out.println("cartDto: " + cartDto);

        //cart 테이블 생성 후 테이블에 저장
//        cartMapper.saveCart(cartDto);

        map.put("msg", "success");



        return map;
    }



}