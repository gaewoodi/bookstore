package com.gaewoodi.bookstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/admin/account")
    public String urlAccount(){
        return "admin/admin_Account";
    }







    @GetMapping("/admin/AccountView")
    public String urlAccountView(){
        return "admin/AccountView";
    }
}
