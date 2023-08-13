package com.gaewoodi.bookstore.controller.mypage;

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


    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("book", cartMapper.getBook());

        return "mypage/cart";
    }


    @PostMapping("/cart")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value = "checkboxResult") String result) {
        Map<String, Object> map = new HashMap<>();

        System.out.println("result 값: " + result);

        String checkResult = "";
        String orCheckResult = "";

        String[] splitResult = result.toString().split(" ");

        for(int i = 0; i < splitResult.length -2; i++) {

//            checkResult = "OR bookId = " + "'" + splitResult[i] + "'";
            checkResult = "'" + splitResult[i] + "'";

            map.put("checkResult", checkResult);

            System.out.println("checkResult: " + checkResult);

            for(int j = 1; j < splitResult.length; j++) {
                orCheckResult = "OR book_id = " + "'" + splitResult[j] + "'";
                map.put("orCheckResult", orCheckResult);

                System.out.println("orCheckResult: " + orCheckResult);

                cartMapper.getCartBookList(map);
            }


        }


        map.put("msg", "success");



        return map;
    }



}
