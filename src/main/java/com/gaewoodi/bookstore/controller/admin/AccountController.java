package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.mappers.admin.AccountMapper;
import com.gaewoodi.bookstore.mappers.admin.LevelMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private LevelMapper levelMapper;

    @Autowired
    private MypageMapper mypageMapper;

    @GetMapping("/admin/account")
    public String urlAccount(Model model ,@RequestParam(defaultValue = "1", value = "page") int page){
        model.addAttribute("acct", accountMapper.getMemberAll());
        model.addAttribute("level", levelMapper.getLevel());

        return "admin/admin_Account";
    }






    @GetMapping("/admin/AccountView")
    public String getAccountView(@RequestParam int regId, Model model){
        if (regId > 0) {
            model.addAttribute("acct", accountMapper.getMemberOne(regId));
            model.addAttribute("level", levelMapper.getLevel());
            model.addAttribute("user", mypageMapper.getMypageId(regId));
        }
        return "admin/AccountView";
    }


}
