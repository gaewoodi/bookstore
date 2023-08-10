package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MypageController {

    @Autowired
    private MypageMapper mypageMapper;

//    @GetMapping("/mypage")
//    public String getMypage() {
//
//
//        return "mypage/mypage";
//    }
    @GetMapping("/mypage")
    public String getMypage(Model model, int regId) {
        model.addAttribute("user", mypageMapper.getMypageId(regId));


        return "mypage/mypage";
    }

//    @PostMapping("/mypage")
//    @ResponseBody
//    public Map<String, Object> setMypage(@ModelAttribute RegisterDto registerDto) {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("msg", "success");
//
//        return map;
//    }


//    @GetMapping("/update")
//    public String getserEdit(Model model, @RequestParam int regId) {
//        model.addAttribute("user", mypageMapper.getMypageId(regId));
//
//
//        return "mypage/user_edit";
//    }
//
//    @PostMapping("/update")
//    public Map<String, Object> setUpdate(@ModelAttribute RegisterDto registerDto) {
//        Map<String, Object> map = new HashMap<>();
//
//        mypageMapper.setRegister(registerDto);
//
//        map.put("msg", "success");
//        return map;
//    }
}
