package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.mypage.LikeDto;
import com.gaewoodi.bookstore.mappers.mypage.BookMapper;
import com.gaewoodi.bookstore.mappers.mypage.LikeMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import com.gaewoodi.bookstore.service.mypage.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private MypageMapper mypageMapper;

    //도서전체
    @GetMapping("")
    public String getBookList(Model model, @RequestParam(defaultValue = "1", value="page") int page) {
        model.addAttribute("book", pagingService.getBookPaging(page));
        model.addAttribute("pagination", pagingService.bookCalculator(page));

        return "mypage/book";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Object> setMypage() {
        Map<String, Object> map = new HashMap<>();

        map.put("msg", "success");

        mypageMapper.getMemberAll();

        return map;
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
    public Map<String, Object> getLike(@ModelAttribute LikeDto likeDto) {

        likeMapper.addLike(likeDto);
        Map<String, Object> map = new HashMap<>();

        map.put("msg", "success");

        return map;

    }

    @GetMapping("/test")
    public String getTest() {
        return "mypage/test";
    }

}
