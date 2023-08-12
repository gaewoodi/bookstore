package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.service.mypage.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SelectService selectService;

    @GetMapping("/cart")
    public String getCart(Model model, @RequestParam int[] bookId, @RequestParam List<String> checkArray) {
        model.addAttribute("book", selectService.getCartBookList(bookId));
        model.addAttribute("cart", selectService.getCartBook(checkArray));

        return "mypage/cart";
    }

//    @GetMapping("/cart")
//    public String getCart(Model model, @RequestParam int bookId) {
//        model.addAttribute("book", cartMapper.getBook(bookId));
//
//        return "mypage/cart";
//    }


    @PostMapping("/cart")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value="checkboxArray[]") List<String> checkArray,
                                         @RequestParam(value = "checkboxResult") String result) {
        Map<String, Object> map = new HashMap<>();

        System.out.println("checkArray 값: " + checkArray);
        System.out.println("result 값: " + result);

//        String[] splitResult = result.toString().split(" ");
//        System.out.println(Integer.parseInt(splitResult));

        map.put("msg", "success");

        return map;
    }

    @GetMapping("/test_check")
    public String getTest() {


        return "mypage/test";
    }

    @PostMapping("/test_check")
    @ResponseBody
    public String setTest(@RequestParam(value = "valueArrTest[]") List<String> valueArr) {
        System.out.println(valueArr);

        return "";
    }







}
