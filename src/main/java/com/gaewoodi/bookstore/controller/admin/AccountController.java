package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.PagingDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import com.gaewoodi.bookstore.mappers.admin.AccountMapper;
import com.gaewoodi.bookstore.mappers.admin.LevelMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import com.gaewoodi.bookstore.service.admin.AccountPagingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    private AccountPagingSrv pagingSrv;

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

        model.addAttribute("emp", pagingSrv.getPagingEmp(page));

        model.addAttribute("pagination", pagingSrv.pageCalc(page));

        return "admin/admin_Account";
    }

    @GetMapping("/admin/employees/delete")
    @ResponseBody
    public Map<String, Object> deleteEmp(@RequestParam int regId) {
        Map<String, Object> map = new HashMap<>();
        if(regId > 0){}
        return map;
    }




    @GetMapping("/admin/AccountView")
    public String getAccountView(@RequestParam int regId, Model model, @ModelAttribute UserImageDto userImageDto){

        if (regId > 0) {
            model.addAttribute("acct", accountMapper.getMemberOne(regId));
            model.addAttribute("level", levelMapper.getLevel());
            model.addAttribute("user", mypageMapper.getRegIdCheck(userImageDto));
            System.out.println(regId);
        }
        return "admin/AccountView";
    }


}
