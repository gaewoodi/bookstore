package com.gaewoodi.bookstore.controller.main;
import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import com.gaewoodi.bookstore.mappers.main.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;


@Controller
public class MainController {

    @Autowired
    private MainMapper mainmapper;

    @GetMapping("/main")
    public String getMain(Model model, BookDto bookDto) {
        model.addAttribute("main", mainmapper.getMainDto(bookDto));
        return "main/index";
    }
}
