package com.gaewoodi.bookstore.controller.mypage;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.mypage.UserImageDto;
import com.gaewoodi.bookstore.mappers.mypage.MypageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageMapper mypageMapper;

    private String UPLOAD_LOCATION = "D:\\bookstore\\src\\main\\resources\\static\\images\\mypage\\user_image";

    @GetMapping("")
    public String getMypage(Model model, int regId) {
        model.addAttribute("user", mypageMapper.getMypageId(regId));


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
            if(uploadFile != null) {
                UserImageDto userImageDto = new UserImageDto();
                userImageDto.setOriginName(uploadFile.getOriginalFilename());
                userImageDto.setImageSize(uploadFile.getSize());
                userImageDto.setRegId(regId);

                mypageMapper.fileUpload(userImageDto);

                Path path = Paths.get(UPLOAD_LOCATION, uploadFile.getOriginalFilename());
                Files.write(path, uploadFile.getBytes());


                map.put("msg", "success");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
