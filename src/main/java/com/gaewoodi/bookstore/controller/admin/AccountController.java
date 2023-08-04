package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.mappers.admin.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;



    @GetMapping("/admin/account")
    public String urlAccount(){

        return "admin/admin_Account";
    }






    @GetMapping("/admin/AccountView")
    public String urlAccountView(){

        return "admin/AccountView";
    }


}
