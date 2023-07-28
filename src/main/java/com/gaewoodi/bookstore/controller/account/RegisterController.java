package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.account.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private RegisterMapper registerMapper;

    @GetMapping("/register")
    public String getRegister() {

        return "account/register";
    }

    @PostMapping("/chkPwd")
    @ResponseBody
    public int chkPwd(@RequestParam String bookRegPasswd) {
        return registerMapper.chkPwd(bookRegPasswd);
    }
}
