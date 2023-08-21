package com.gaewoodi.bookstore.controller.admin;

import com.gaewoodi.bookstore.mappers.admin.InventoryMapper;
import com.gaewoodi.bookstore.service.admin.BookPagingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InventoryController {

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
    public String urlInventoryAdd(Model model){




        return "admin/Admin_InventoryUpdate";
    }
}
