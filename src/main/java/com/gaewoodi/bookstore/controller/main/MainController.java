package com.gaewoodi.bookstore.controller.main;
import com.gaewoodi.bookstore.dto.BookDto;
import com.gaewoodi.bookstore.dto.main.BestsellerDto;
import com.gaewoodi.bookstore.dto.main.MainDto;
import com.gaewoodi.bookstore.mappers.main.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MainMapper mainmapper;

    @GetMapping("/main")

    public String getMain(Model model, BookDto bookDto) {
//        스콘
        System.out.println(bookDto);
        model.addAttribute("mst", mainmapper.getMst());
        model.addAttribute("main", mainmapper.getMainDto());


//        슬라이드
        model.addAttribute("slide", mainmapper.getImage());
//        개우디
        model.addAttribute("gawoody", mainmapper.getGawoody());
        model.addAttribute("mz", mainmapper.getMz());
        model.addAttribute("trend", mainmapper.getTrend());
        model.addAttribute("publisher", mainmapper.getPublisher());
        model.addAttribute("media", mainmapper.getMedia());
        model.addAttribute("thisbook", mainmapper.getThisBook());
        model.addAttribute("literature", mainmapper.getLiterature());
        model.addAttribute("child", mainmapper.getChild());
        model.addAttribute("living", mainmapper.getLiving());
        model.addAttribute("politic", mainmapper.getPolitic());
        model.addAttribute("humanity", mainmapper.getHumanity());
        model.addAttribute("it", mainmapper.getIt());
        model.addAttribute("self", mainmapper.getSelf());
        return "main/index";
    }

    @PostMapping("/main")
    @ResponseBody
    public Map<String, Object> getLike(@ModelAttribute BookDto bookDto) {
        Map<String, Object> map = new HashMap<>();
        mainmapper.getLike(bookDto);
        map.put("msg", "success");
        System.out.println(mainmapper.getBookmst(bookDto));
        return map;
    }
}
