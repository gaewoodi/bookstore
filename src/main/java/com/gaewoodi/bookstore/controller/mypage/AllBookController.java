package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
import com.gaewoodi.bookstore.mappers.mypage.BookMapper;
import com.gaewoodi.bookstore.service.mypage.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class AllBookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private PagingService pagingService;

    @GetMapping("")
    public String getBookList(Model model, @RequestParam(defaultValue = "1", value="page") int page) {
        model.addAttribute("book", pagingService.getBookPaging(page));
        model.addAttribute("pagination", pagingService.bookCalculator(page));

        return "mypage/book";
    }

    @PostMapping("")
    public String setMultiCheck(@RequestParam List<String> check) {
        for (String c : check) {
            System.out.println(c);
        }

        return "";
    }
}
