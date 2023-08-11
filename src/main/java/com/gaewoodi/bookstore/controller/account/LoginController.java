package com.gaewoodi.bookstore.controller.account;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.mappers.account.LoginMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginMapper loginMapper;

    @GetMapping("/login")
    public String getLogin() {
        return "account/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> checkLogin(@ModelAttribute RegisterDto registerDto, HttpServletRequest req) {

        Map<String, Object> map = new HashMap<>();
        System.out.println(loginMapper.getBookInfo(registerDto));
        RegisterDto r = loginMapper.getBookInfo(registerDto);

        HttpSession hs = req.getSession();

        if(r.getLevel() > 1 && r != null) {

            hs.setAttribute("adminChk", r);
            hs.setMaxInactiveInterval(60 * 30);

            map.put("msg", "confirm");

        }else{
            hs.setAttribute("regId", r.getRegId());
            hs.setAttribute("id", r.getId());
            hs.setAttribute("passwd", r.getPasswd());

            map.put("msg", "consumer login");
        }

        return map;

    }

    @GetMapping("/logout")
    public String getLogout(HttpSession hs) {
        hs.invalidate();
        return "redirect:/main";
    }
}
