package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.account.FindIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FindIdController {

    @Autowired
    private FindIdMapper findIdMapper;

    @PostMapping("/findid")
    @ResponseBody
    public int getCheck(@ModelAttribute RegisterDto registerDto) {

        return findIdMapper.getFindInfo(registerDto);
    }

    @GetMapping("/findid")
    public String getPages() {
        return "account/findid";
    }
}
