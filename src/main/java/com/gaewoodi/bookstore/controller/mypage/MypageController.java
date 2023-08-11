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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageMapper mypageMapper;

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
            String filePath = "D:\\bookstore\\upload";
            String orginName = uploadFile.getOriginalFilename();
            Long fileSize = uploadFile.getSize();

            //폴더 이름은 2023-06-27 => new SimpleDateFormat() 사용
            String folderName = new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
            File file = new File(filePath +"\\"+ folderName);

            if(uploadFile != null) {
                file.mkdir();
                System.out.println("폴더가 생성 되었습니다.");

                UserImageDto userImageDto = new UserImageDto();

                userImageDto.setOriginName(orginName);
                userImageDto.setImageSize(fileSize);
                userImageDto.setRegId(regId);

//                mypageMapper.getUserIamge(userImageDto);
                mypageMapper.fileUpload(userImageDto);

                String partially = orginName.substring(orginName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;

                Path path = Paths.get(file.toString(), changeName);
                Files.write(path, uploadFile.getBytes());


                map.put("msg", "success");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
