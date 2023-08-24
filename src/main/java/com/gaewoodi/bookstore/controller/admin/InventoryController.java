package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.mappers.admin.InventoryMapper;
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
    private InventoryMapper inventoryMapper;

    @GetMapping("/admin/inventory")
    public String urlInventory(Model model){
        model.addAttribute("bookInfo", inventoryMapper.getBookAll());
        model.addAttribute("cnt", inventoryMapper.getTotalCount());
        model.addAttribute("zeroCnt", inventoryMapper.getBookStockCount());

        return "admin/admin_Inventory";
    }

    @GetMapping("/admin/inventoryUpdate")
    public String getBookUpdate(@RequestParam int bookId, Model model, @ModelAttribute BookDto bookDto){

        if (bookId > 0) {
            model.addAttribute("bookInfo", inventoryMapper.getBookOne(bookId));
            System.out.println(bookDto.getBookId());
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
                BookDto bookDto = new BookDto();

                bookDto.setOriginName(originName);
                bookDto.setSize(fileSize);
                bookDto.setBookId(bookId);

                String partially = originName.substring(originName.lastIndexOf("."));
                String changeName = System.currentTimeMillis() + partially;
                bookDto.setSaveName(changeName);
                inventoryMapper.updateBookImage(bookDto);

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
