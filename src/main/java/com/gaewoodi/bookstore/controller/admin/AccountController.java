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

    @Value("${spring.servlet.multipart.location}")
    private String user_image = "D:\\bookstore\\src\\main\\resources\\static\\images\\mypage\\user_image";

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
    @GetMapping("/admin/AccountView/deleteImg")
    @ResponseBody
    public Map<String, Object> deleteAccountImg(@RequestParam int regId) {
        Map<String, Object> map = new HashMap<>();

        if(regId > 0){
            RegisterDto rdto = accountMapper.getImageName(regId);

            System.out.println(rdto.getSaveName());

            File file = new File(user_image+ "\\" + rdto.getSaveName());
            boolean b = file.delete();

            if(b){
                System.out.println("회원 이미지를 삭제에 성공했습니다.");
            }
            map.put("msg", "success");
        }else{
            System.out.println("회원 이미지가 없습니다.");
        }

        return map;
    }

    @GetMapping("/admin/AccountView/delete")
    @ResponseBody
    public Map<String, Object> deleteAccount(@RequestParam int regId){
        Map<String, Object> map = new HashMap<>();
        if(regId>0){
            accountMapper.deleteAccount(regId);
            map.put("msg", "success");
        }
        return map;
    }



}
