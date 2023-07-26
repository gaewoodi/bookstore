package com.gaewoodi.bookstore.controller.book;

import com.gaewoodi.bookstore.mappers.book.BestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BestMapper bestMapper;

    @GetMapping("/best")
    public String getList(Model model) {
        model.addAttribute("list", bestMapper.getBestDtoList());
        return "book/best";
    }

    @GetMapping("/search")
    public String getSearch(Model model) {
        model.addAttribute("list", bestMapper.getBestDtoList());
        return "book/search";
    }


}
