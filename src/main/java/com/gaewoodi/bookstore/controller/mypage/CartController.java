package com.gaewoodi.bookstore.controller.mypage;


import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private MypageMapper mypageMapper;

    @GetMapping("")
    public String getCart(Model model, @RequestParam int regId) {
        model.addAttribute("count", cartMapper.getCartCount(regId));
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        model.addAttribute("book", cartMapper.getCartBookList(regId));

        return "mypage/cart";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Object> setMypage(@RequestParam(value = "checkboxResult") String result,
                                         @RequestParam(value = "regIdValue") int regId,
                                         @ModelAttribute CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();

        cartDto.setRegId(regId);

        String[] splitResult = result.toString().split(" ");
        System.out.println(splitResult.length);

        for(int i = 0; i < splitResult.length; i++) {
            if(i == 0) {
                cartDto.setBookId(Integer.parseInt(splitResult[0]));
            } else if(i == 1) {
                cartDto.setBookId(Integer.parseInt(splitResult[1]));
            } else if(i == 2) {
                cartDto.setBookId(Integer.parseInt(splitResult[2]));
            }
            cartMapper.saveCart(cartDto);

            map.put("data" + i, cartMapper.getCartBookList(Integer.parseInt(splitResult[i])));
        }

        map.put("msg", "success");

        return map;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Map<String, Object> cartDelete(@ModelAttribute CartDto cartDto,
                                          @RequestParam(value = "checkboxResult") String result,
                                          @RequestParam(value = "bookIdValue") String bookId) {
        Map<String, Object> map = new HashMap<>();

        cartMapper.deleteCart(Integer.parseInt(result));

        map.put("msg", "success");

        return map;
    }

}