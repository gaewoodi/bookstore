package com.gaewoodi.bookstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {

    @GetMapping("/admin/inventory")
    public String urlInventory(){
        return "admin/admin_Inventory";
    }

    @GetMapping("/admin/inventoryForm")
    public String urlInventoryAdd(){
        return "admin/admin_Inventory_add";
    }
}
