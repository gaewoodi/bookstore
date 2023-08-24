package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.mappers.admin.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class DashboardController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/admin/dashboard")
    public String urlAdmin() {
        return "admin/dashboard";
    }

}


