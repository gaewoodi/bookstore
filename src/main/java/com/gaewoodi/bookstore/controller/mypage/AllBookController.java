package com.gaewoodi.bookstore.controller.mypage;

<<<<<<< HEAD
=======
import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.mypage.CartDto;
>>>>>>> mypage
import com.gaewoodi.bookstore.mappers.mypage.BookMapper;
import com.gaewoodi.bookstore.service.mypage.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> mypage

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

<<<<<<< HEAD
        return "purchase/book";
    }

=======
        return "mypage/book";
    }

    @PostMapping("")
    public String setMultiCheck(@RequestParam List<String> check) {
        for (String c : check) {
            System.out.println(c);
        }

        return "";
    }
>>>>>>> mypage
}
