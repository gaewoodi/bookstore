package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.account.FindIdMapper;
import com.gaewoodi.bookstore.mappers.account.LoginMapper;
import com.gaewoodi.bookstore.mappers.account.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FindIdController {

    @Autowired
    private FindIdMapper findIdMapper;

    @Autowired
    private LoginMapper loginMapper;

    @PostMapping("/findid")
    @ResponseBody
<<<<<<< HEAD
    public int getCheck(@ModelAttribute RegisterDto registerDto) {

        return findIdMapper.getFindInfo(registerDto);
=======
    public Map<String, Object> getCheck(@ModelAttribute RegisterDto registerDto) {
        Map<String, Object> map = new HashMap<>();
        if( loginMapper.getCheck(registerDto) != null ) {
            map.put("id", loginMapper.getCheck(registerDto).getId());
        }else{
            map.put("id", "");
        }
        return map;
>>>>>>> ef861ad2b3cb85adbd3591a8b5da72bedb06ee07
    }

    @GetMapping("/findid")
    public String getPages() {
        return "account/findid";
    }
}
