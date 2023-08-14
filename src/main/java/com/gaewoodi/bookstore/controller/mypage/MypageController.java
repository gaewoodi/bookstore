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
    public String getMypage(Model model, int regId, @ModelAttribute UserImageDto userImageDto) {
        model.addAttribute("user", mypageMapper.getMypageId(regId));
        System.out.println(userImageDto);


        if(userImageDto.getOriginName() == null) {
            mypageMapper.getUserIamge(userImageDto);
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

                System.out.println("orginName: " + orginName);
                System.out.println("fileSize: " + fileSize);
                System.out.println("regId: " + regId);

                userImageDto.setOriginName(orginName);
                userImageDto.setImageSize(fileSize);
                userImageDto.setRegId(regId);

                String partially = orginName.substring(orginName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;
                System.out.println("changeName: " + changeName);
                userImageDto.setSaveName(changeName);
                mypageMapper.fileUpload(userImageDto);


                map.put("msg", "success");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @GetMapping("/test")
    public String getTest() {

        return "mypage/test";
    }

    @PostMapping("/test")
    @ResponseBody
//    첨부파일을 받을 땐, MultipartFile로 받아야함.
    public String fileUpload(MultipartFile uploadFile) {

        try {
            // 상수 표기 법은 대문자이기 때문에 대문자로 표기
            String UPLOAD_DIR = "C:\\Temp";

            //파일 이름 암호화 하는 방법
            String uuid = UUID.randomUUID().toString();
//            1000분의 1초
            long sysdate = System.currentTimeMillis();

            String originName = uploadFile.getOriginalFilename();
            String fileExt = uploadFile.getOriginalFilename()
                    .substring(originName.lastIndexOf(".") + 1, originName.length());

            String transFileName = uuid + "_" + sysdate + "." + fileExt;

//            Path path = Paths.get(폴더, 파일이름);
            Path path = Paths.get(UPLOAD_DIR, transFileName);
            Files.write(path, uploadFile.getBytes());


        }catch (Exception e) {
            e.printStackTrace();
        }


        return "";
    }
}
