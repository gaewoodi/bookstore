package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import com.gaewoodi.bookstore.mappers.mypage.CartMapper;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/mypage")
public class MypageController {


    @Autowired
    private MypageMapper mypageMapper;

    @Autowired
    private CartMapper cartMapper;

    @GetMapping("")
    public String getMypage(Model model, @ModelAttribute UserImageDto userImageDto) {
        model.addAttribute("count", cartMapper.getCartCount(userImageDto.getRegId()));
        model.addAttribute("user", mypageMapper.getMypageId(userImageDto.getRegId()));

        return "mypage/mypage";
    }


    @GetMapping("/update")
    public String getserEdit(Model model, @RequestParam int regId) {
        model.addAttribute("count", cartMapper.getCartCount(regId));
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        return "mypage/user_edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> setUpdate(@ModelAttribute RegisterDto registerDto) {
        System.out.println(registerDto);
        Map<String, Object> map = new HashMap<>();

        mypageMapper.updateRegister(registerDto);

        map.put("msg", "success");
        return map;
    }

    @PostMapping("/update/upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile uploadFile, int regId) {
        Map<String, Object> map = new HashMap<>();

        try {
//            String FILE_PATH = "D:\\bookstore\\src\\main\\resources\\static\\images\\mypage\\user_image";
            String FILE_PATH = "C:\\Users\\dndpg\\OneDrive\\document\\bookstore\\src\\main\\resources\\static\\images\\mypage\\user_image";
            String orginName = uploadFile.getOriginalFilename();
            Long fileSize = uploadFile.getSize();


            if(uploadFile != null) {
                UserImageDto userImageDto = new UserImageDto();

                userImageDto.setOriginName(orginName);
                userImageDto.setImageSize(fileSize);
                userImageDto.setRegId(regId);

                String partially = orginName.substring(orginName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;
                userImageDto.setSaveName(changeName);
                System.out.println("fileSize: " + fileSize);

                mypageMapper.fileUpload(userImageDto);

                Path path = Paths.get(FILE_PATH, changeName);
                Files.write(path, uploadFile.getBytes());

                map.put("msg", "success");

            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


}
