package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

//    @GetMapping("/cart")
//    @ResponseBody
//    public String getCart() {
//
//        return "mypage/cart";
//    }

    @GetMapping("/cart")
    public String getCart(Model model, @ModelAttribute CartDto cartDto) {
        model.addAttribute("book", cartMapper.getCartBookList(cartDto.getRegId()));


        return "mypage/cart";
    }


    @PostMapping("/cart")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value = "checkboxResult") String result, CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(cartDto.getRegId());

        String checkResult = "";
        String orCheckResult = "";

        String[] splitResult = result.toString().split(" ");

        for (int i = 0; i < splitResult.length - 2; i++) {

            checkResult = "'" + splitResult[i] + "'";

            map.put("checkResult", checkResult);

            System.out.println("checkResult: " + checkResult);

            for (int j = 1; j < splitResult.length; j++) {
                orCheckResult = "OR book_id = " + "'" + splitResult[j] + "'";
                map.put("orCheckResult", orCheckResult);

                System.out.println("orCheckResult: " + orCheckResult);

                cartMapper.saveCart(map);
            }



        }
        map.put("msg", "success");


        return map;
    }
//    @GetMapping("/test")
//    public String getTest(Model model) {
//
//        return "mypage/test";
//    }




}