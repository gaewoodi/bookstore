package com.gaewoodi.bookstore.controller.purchase;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.mappers.purchase.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("/cart")
    public String getCart(Model model, @RequestParam int bookId) {
        model.addAttribute("cart", cartMapper.getCartBook(bookId));

        return "purchase/cart";
    }


}
