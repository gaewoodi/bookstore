package com.gaewoodi.bookstore.controller.mypage;


import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
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
    private MypageMapper mypageMapper;


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
    public String getCart(Model model, @RequestParam int bookId, @RequestParam int regId) {
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        model.addAttribute("book", cartMapper.getCartBookList(regId));

        return "mypage/cart";
    }

    @PostMapping("/cart")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value = "checkboxResult") String result,
                                         @RequestParam(value = "regIdValue") int regId,
                                         @ModelAttribute CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();

        System.out.println("result 값: " + result);
        System.out.println("regId 값: " + regId);

        cartDto.setRegId(regId);

        String[] splitResult = result.toString().split(" ");

        for(int i = 0; i < splitResult.length; i++) {
            System.out.println("splitResult: " + splitResult[i]);
            if(i == 0) {
                cartDto.setBookId(Integer.parseInt(splitResult[0]));
                System.out.println("0실행됨");
            } else if(i == 1) {
                cartDto.setBookId(Integer.parseInt(splitResult[1]));
                System.out.println("1실행됨");
            } else if(i == 2) {
                cartDto.setBookId(Integer.parseInt(splitResult[2]));
                System.out.println("2실행됨");
            }
            cartMapper.saveCart(cartDto);

            map.put("data" + i, cartMapper.getCartBookList(Integer.parseInt(splitResult[i])));



        }
        System.out.println("저장된 bookId: " + cartDto.getBookId());
        map.put("msg", "success");

        return map;
    }



//    @PostMapping("/cart")
//    @ResponseBody
//    public String setMypage(@RequestParam(value = "checkboxResult") String result) {
//
//        System.out.println("result 값: " + result);
//        String searchQuery = "";
//
//        String checkResult = "";
//        String orCheckResult = "";
//
//        String[] splitResult = result.toString().split(" ");
//
//        for(int i = 0; i < splitResult.length -2; i++) {
//
////            checkResult = "OR bookId = " + "'" + splitResult[i] + "'";
//            checkResult = "'" + splitResult[i] + "'";
//
//
////            System.out.println("checkResult: " + checkResult);
//
//            for(int j = 1; j < splitResult.length; j++) {
//                orCheckResult = " OR book_id = " + "'" + splitResult[j] + "'";
////                map.put("orCheckResult", orCheckResult);
//
////                System.out.println("orCheckResult: " + orCheckResult);
//
//                    searchQuery = checkResult + orCheckResult;
//                    System.out.println("checkResult: " + checkResult);
//                    System.out.println("orCheckResult: " + orCheckResult);
//                    System.out.println("------------------------");
//                    System.out.println(searchQuery);
//
////                    map.put("searchQuery", searchQuery);
//
//                    cartMapper.getCartBookList(checkResult);
//
//            }
//
//        }
//
//
//
//
//        return "mypage/cart";
//    }
//    @GetMapping("/test")
//    public String getTest(Model model) {
//
//        return "mypage/test";
//    }




}