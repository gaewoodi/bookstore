package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.dto.account.RegisterDto;
import com.gaewoodi.bookstore.dto.admin.AdminBookDto;
import com.gaewoodi.bookstore.mappers.admin.InventoryMapper;
import com.gaewoodi.bookstore.service.admin.BookPagingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class InventoryController {

    @Value("${spring.servlet.multipart.location}")
    private String book_image = "D:\\bookstore\\src\\main\\resources\\static\\images\\temp";

    @Autowired
    private BookPagingSrv pagingSrv;

    @Autowired
    private InventoryMapper inventoryMapper;

    @GetMapping("/admin/inventory")
    public String urlInventory(Model model,@RequestParam(defaultValue = "1", value = "page") int page){
        model.addAttribute("bookInfo", inventoryMapper.getBookAll());

        model.addAttribute("book", pagingSrv.getPagingBook(page));

        model.addAttribute("pagination", pagingSrv.pageCalc(page));

        return "admin/admin_Inventory";
    }

    @GetMapping("/admin/inventoryUpdate")
    public String getBookUpdate(@RequestParam int bookId, Model model, @ModelAttribute AdminBookDto adminBookDto){

        if (bookId > 0) {
            model.addAttribute("bookInfo", inventoryMapper.getBookOne(bookId));
            System.out.println(adminBookDto.getBookId());
        }

        return "admin/Admin_InventoryUpdate";
    }



    @PostMapping("/admin/inventoryUpdate/Img")
    @ResponseBody
    public Map<String, Object> inventoryImgUpload(MultipartFile uploadFile,@RequestParam int bookId){
        Map<String, Object> map = new HashMap<>();

        try {
            String FILE_PATH = "D:\\bookstore\\src\\main\\resources\\static\\images\\temp";
            String originName = uploadFile.getOriginalFilename();
            Long fileSize = uploadFile.getSize();

            if(uploadFile != null) {
                AdminBookDto adminBookDto = new AdminBookDto();

                adminBookDto.setOriginName(originName);
                adminBookDto.setSize(fileSize);
                adminBookDto.setBookId(bookId);

                String partially = originName.substring(originName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;
                adminBookDto.setSaveName(changeName);
                inventoryMapper.updateBookImage(adminBookDto);

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
