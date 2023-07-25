package com.gaewoodi.bookstore.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {
        return "account/login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "account/register";
    }


}
