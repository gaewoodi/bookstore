package com.gaewoodi.bookstore.controller.book;

import com.gaewoodi.bookstore.dto.book.BestDto;
import com.gaewoodi.bookstore.mappers.book.BestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BestController {

    @Autowired
    private BestMapper bestMapper;

    @GetMapping("/best")
    public String getList(Model model) {
        int count = bestMapper.totalBookCount();

        model.addAttribute("list", bestMapper.getBestDtoList());

        return "book/best";
    }



}
