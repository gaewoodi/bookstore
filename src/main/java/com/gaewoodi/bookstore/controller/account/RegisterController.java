package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import com.gaewoodi.bookstore.mappers.account.RegisterMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class RegisterController {

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private MypageMapper mypageMapper;

    @GetMapping("/register")
    public String getRegister() {

        return "account/register";
    }

    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> saveRegister(@ModelAttribute RegisterDto registerDto,
                                            @ModelAttribute UserImageDto userImageDto) {
        System.out.println(registerDto);
        Map<String, Object> map = new HashMap<>();
        UserImageDto imageCheck = mypageMapper.getRegIdCheck(userImageDto);
//        if(registerDto != null) {
//            registerMapper.saveRegister(registerDto);
//            map.put("msg", "success");
//        }
        registerMapper.saveRegister(registerDto);

        if(imageCheck == null && userImageDto.getRegId() > 1) {
            mypageMapper.getUserImage(userImageDto);
        }
        map.put("msg", "success");

        return map;
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam String id) {
        System.out.println(id);
        return registerMapper.idCheck(id);
    }
}

