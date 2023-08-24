package com.gaewoodi.bookstore.controller.mypage;


import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import com.gaewoodi.bookstore.service.mypage.SelectService;
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

    @Autowired
    private SelectService selectService;

    @GetMapping("")
    public String getCart(Model model, @RequestParam int regId) {
        model.addAttribute("count", cartMapper.getCartCount(regId));
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        model.addAttribute("book", cartMapper.getCartBookList(regId));

        return "mypage/cart";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Object> setCart(@RequestParam(value = "checkboxResult") String result,
                                         @RequestParam(value = "regIdValue") int regId,
                                         @ModelAttribute CartDto cartDto) {
        Map<String, Object> map = new HashMap<>();

        selectService.getCartCheckboxResult(result, regId, cartDto);
        map.put("msg", "success");

        return map;
    }

    @GetMapping("/delete")
    @ResponseBody
    public Map<String, Object> cartDelete(@RequestParam(value = "checkboxResult") int result,
                                          @RequestParam(value = "regIdValue") int regId) {
        Map<String, Object> map = new HashMap<>();

        cartMapper.deleteCart(regId, result);

        map.put("msg", "success");

        return map;
    }

}