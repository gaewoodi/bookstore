package com.gaewoodi.bookstore.controller.purchase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartContainer {
    @GetMapping("/cart")
    public String getCart() {
        return "purchase/cart";
    }
}
