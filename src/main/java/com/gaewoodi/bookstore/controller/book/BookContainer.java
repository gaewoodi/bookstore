package com.gaewoodi.bookstore.controller.book;

import com.gaewoodi.bookstore.dto.purchase.PurchaseDto;
import com.gaewoodi.bookstore.mappers.book.BookMapper;
import com.gaewoodi.bookstore.mappers.purchase.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookContainer {

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("")
    public String getBookList(Model model) {
        model.addAttribute("book", bookMapper.getBook());
        
        return "book/book";
    }
}
