package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.LikeDto;
import com.gaewoodi.bookstore.mappers.mypage.BookMapper;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.LikeMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import com.gaewoodi.bookstore.service.mypage.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private PagingService pagingService;

    @Autowired
    private LikeMapper likeMapper;

    //도서전체
    @GetMapping("")
    public String getBookList(Model model, @RequestParam(defaultValue = "1", value="page") int page) {
        model.addAttribute("book", pagingService.getBookPaging(page));
        model.addAttribute("pagination", pagingService.bookCalculator(page));

        return "mypage/book";
    }

    //도서상세
    @GetMapping("/view")
    public String viewBook(@RequestParam int bookId, Model model) {
        if(bookId > 0) {
            bookMapper.updateVisit(bookId);
            model.addAttribute("book", bookMapper.viewBook(bookId));

        }

        return "mypage/view";
    }

    @PostMapping("/like")
    public String getLike(@RequestParam(value = "bookLike") int like) {
        BookDto bookDto = new BookDto();

        bookDto.setBookLike(like);
        System.out.println("like:" + like);

        likeMapper.setBookLikeCount(bookDto);

        return "redirect:/book";

    }




}
