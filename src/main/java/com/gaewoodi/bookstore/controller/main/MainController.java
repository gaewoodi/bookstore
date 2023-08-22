package com.gaewoodi.bookstore.controller.main;
import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.BestsellerDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import com.gaewoodi.bookstore.mappers.main.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLOutput;


@Controller
public class MainController {
    @Autowired
    private MainMapper mainmapper;

    @GetMapping("/main")
    public String getMain(Model model) {
        model.addAttribute("mst", mainmapper.getMst());
        model.addAttribute("main", mainmapper.getMainDto());
        model.addAttribute("slide", mainmapper.getImage());
        model.addAttribute("gawoody", mainmapper.getGawoody());
        model.addAttribute("mz", mainmapper.getMz());
        model.addAttribute("trend", mainmapper.getTrend());
        model.addAttribute("publisher", mainmapper.getPublisher());
        model.addAttribute("media", mainmapper.getMedia());
        model.addAttribute("thisbook", mainmapper.getThisBook());
        return "main/index";
    }
}
