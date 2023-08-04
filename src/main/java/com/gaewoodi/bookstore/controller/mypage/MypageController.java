package com.gaewoodi.bookstore.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    @GetMapping("/mypage")
    public String getMypage() {
        return "mypage/mypage";
    }

    @GetMapping("/user/edit")
    public String getserEdit() {

        return "mypage/user_edit";
    }
}
