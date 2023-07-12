package com.gaewoodi.bookstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/admin/Account")
    public String urlAccount(){
        return "admin/admin_Account";
    }
}
