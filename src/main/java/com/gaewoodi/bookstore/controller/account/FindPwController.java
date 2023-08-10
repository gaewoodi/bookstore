package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.account.FindPwMapper;
import com.gaewoodi.bookstore.mappers.account.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FindPwController {

    @Autowired
    private FindPwMapper findPwMapper;

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/findpw")
    public String getPages() {
        return "account/findpw";
    }

    @PostMapping("/findpw")
    @ResponseBody
    public Map<String, Object> getPwChk(@ModelAttribute RegisterDto registerDto) {
        Map<String, Object> map = new HashMap<>();
        if(loginMapper.getPwChk(registerDto) != null) {
            map.put("passwd", loginMapper.getPwChk(registerDto).getPasswd());
        }else {
            map.put("passwd", "");
        }
        return map;
    }
}
