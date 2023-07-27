package com.gaewoodi.bookstore.controller.purchase;

import com.gaewoodi.bookstore.mappers.purchase.BookMapper;
import com.gaewoodi.bookstore.service.purchase.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        return "purchase/book";
    }

}
