package com.gaewoodi.bookstore.controller.purchase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @GetMapping("/list")
    public String getPurchaseList() {
        return "purchase/purchase_list";
    }

    @GetMapping("/delete")
    public String getPurchaseDelete() {
        return "purchase/purchase_delete";
    }
}

