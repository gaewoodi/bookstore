package com.gaewoodi.bookstore.controller.purchase;

import com.gaewoodi.bookstore.dto.purchase.CartDto;
import com.gaewoodi.bookstore.mappers.book.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartMapper.getCartBook());

        return "purchase/cart";
    }

    @PostMapping("/cart")
    @ResponseBody
    public  Map<String, Object> getCart(@ModelAttribute CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();

        cartMapper.getBookData();

        map.put("msg", "success");


        return map;
    }
}
