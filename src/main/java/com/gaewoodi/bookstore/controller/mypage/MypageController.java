package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    private String UPLOAD_LOCATION = "D:\\bookstore\\src\\main\\resources\\static\\images\\upload";

    @Autowired
    private MypageMapper mypageMapper;

    @GetMapping("")
    public String getMypage(Model model, @ModelAttribute UserImageDto userImageDto) {
        UserImageDto imageCheck = mypageMapper.getRegIdCheck(userImageDto);

        model.addAttribute("user", mypageMapper.getMypageId(userImageDto.getRegId()));

        if(imageCheck == null && userImageDto.getRegId() > 1) {
            mypageMapper.getUserImage(userImageDto);
        }

        return "mypage/mypage";
    }


    @GetMapping("/update")
    public String getserEdit(Model model, @RequestParam int regId) {
        model.addAttribute("user", mypageMapper.getMypageId(regId));


        return "mypage/user_edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> setUpdate(@ModelAttribute RegisterDto registerDto) {
        Map<String, Object> map = new HashMap<>();

        mypageMapper.setRegister(registerDto);

        map.put("msg", "success");
        return map;
    }

    @PostMapping("/update/upload")
    @ResponseBody
    public Map<String, Object> fileUpload(MultipartFile uploadFile, int regId) {
        Map<String, Object> map = new HashMap<>();

        try {
            String FILE_PATH = "D:\\bookstore\\src\\main\\resources\\static\\images\\mypage\\user_image";
            String orginName = uploadFile.getOriginalFilename();
            Long fileSize = uploadFile.getSize();


            if(uploadFile != null) {
                UserImageDto userImageDto = new UserImageDto();

                userImageDto.setOriginName(orginName);
                userImageDto.setImageSize(fileSize);
                userImageDto.setRegId(regId);

                System.out.println("orginName: " + orginName);
                System.out.println("fileSize: " + fileSize);
                System.out.println("regId: " + regId);

                String partially = orginName.substring(orginName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;
                userImageDto.setSaveName(changeName);
                mypageMapper.fileUpload(userImageDto);

                System.out.println("changeName: " + changeName);
                Path path = Paths.get(FILE_PATH, orginName);
                Files.write(path, uploadFile.getBytes());

                map.put("msg", "success");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


}
