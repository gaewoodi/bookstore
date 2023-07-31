package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

=======
>>>>>>> mypage
@Controller
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("/cart")
    public String getCart(Model model, @RequestParam int bookId) {
<<<<<<< HEAD
        model.addAttribute("cart", cartMapper.getCartBook(bookId));

        return "purchase/cart";
    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> saveCart(@RequestParam int bookId) {
        Map<String, Object> map = new HashMap<>();

        cartMapper.getBookData(bookId);
        map.put("msg", "success");

        System.out.println(bookId);
        return map;

    }
=======
        model.addAttribute("book", cartMapper.getCartBook(bookId));


        return "mypage/cart";
    }


>>>>>>> mypage

}
