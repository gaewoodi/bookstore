package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("/cart")
    public String getCart(Model model, @RequestParam int bookId) {
        model.addAttribute("book", cartMapper.getCartBook(bookId));


        return "mypage/cart";
    }



}
