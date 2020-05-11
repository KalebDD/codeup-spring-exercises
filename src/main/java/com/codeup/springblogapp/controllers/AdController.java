package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

    @GetMapping("/ads/view")
    public String showAds(Model model) {
        List<Ad> adList = new ArrayList<>();

        Ad ad = new Ad("New car", "Bright red");
        adList.add(ad);
        ad = new Ad("New toy", "Color is blue");
        adList.add(ad);

        model.addAttribute("ads", adList);
        return "ads/index";
    }
}
