package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.service.mypage.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private SelectService selectService;

    @GetMapping("/cart")
        public String getCart(Model model,
                              @RequestParam int[] bookId) {
            model.addAttribute("book", selectService.getCartBookList(bookId));

            return "mypage/cart";
        }



}
