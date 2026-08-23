package com.harsha.spring_boot_url_shortner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Url shortener-backend");
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
