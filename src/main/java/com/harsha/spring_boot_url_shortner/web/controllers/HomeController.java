package com.harsha.spring_boot_url_shortner.web.controllers;

//import com.harsha.spring_boot_url_shortner.ApplicationProperties;
//import com.harsha.spring_boot_url_shortner.domain.entities.ShortUrl;
//import com.harsha.spring_boot_url_shortner.domain.models.ShortUrlDto;
//import com.harsha.spring_boot_url_shortner.domain.repositories.ShortUrlRepository;
//import com.harsha.spring_boot_url_shortner.web.dtos.CreateShortUrlForm;
//import jakarta.validation.Valid;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.naming.Binding;
//import java.util.List;
//
//@Controller
//public class HomeController {
//    private final ShortUrlRepository shortUrlRepository;
//
//    public HomeController(ShortUrlRepository shortUrlRepository){
//        this.shortUrlRepository = shortUrlRepository;
//    }
//
//    @GetMapping("/")
//    public String home(Model model){
//        List<ShortUrl> shortUrls = shortUrlRepository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));
//        model.addAttribute("shortUrls",shortUrls);
//        model.addAttribute("baseUrl", "http://localhost:8080");
//        model.addAttribute("CreateShortUrlForm",new CreateShortUrlForm());
//        return "index";
//    }
//
//    @PostMapping("/short-urls")
//    String createShorturl(@ModelAttribute("CreateShortUrlForm") @Valid CreateShortUrlForm createShortUrlForm,
//                          BindingResult bindingResult,
//                          RedirectAttributes redirectAttributes,
//                          Model model){
//        if(bindingResult.hasErrors())
//        {
//            return "index";
//        }
//
//
//        return "redirect:/";
//    }
//
//}
import com.harsha.spring_boot_url_shortner.domain.services.ShortUrlServices;

import com.harsha.spring_boot_url_shortner.ApplicationProperties;
import com.harsha.spring_boot_url_shortner.domain.models.CreateShortUrlCmd;
import com.harsha.spring_boot_url_shortner.domain.models.ShortUrlDto;
import com.harsha.spring_boot_url_shortner.web.dtos.CreateShortUrlForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    private final ShortUrlServices shortUrlService;
    private final ApplicationProperties properties;

    public HomeController(ShortUrlServices shortUrlService, ApplicationProperties properties) {
        this.shortUrlService = shortUrlService;
        this.properties = properties;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ShortUrlDto> shortUrls = shortUrlService.findAllPublicShortUrls();
        model.addAttribute("shortUrls", shortUrls);
        model.addAttribute("baseUrl", properties.baseUrl());
        model.addAttribute("createShortUrlForm", new CreateShortUrlForm(""));
        return "index";
    }

    @PostMapping("/short-urls")
    String createShortUrl(@ModelAttribute("createShortUrlForm") @Valid CreateShortUrlForm form,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        if(bindingResult.hasErrors()) {
            List<ShortUrlDto> shortUrls = shortUrlService.findAllPublicShortUrls();
            model.addAttribute("shortUrls", shortUrls);
            model.addAttribute("baseUrl", properties.baseUrl());
            return "index";
        }

        try {
            CreateShortUrlCmd cmd = new CreateShortUrlCmd(form.originalUrl());
            var shortUrlDto = shortUrlService.createShortUrl(cmd);
            redirectAttributes.addFlashAttribute("successMessage", "Short URL created successfully "+
                    properties.baseUrl()+"/s/"+shortUrlDto.shortKey());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to create short URL");

        }
        return "redirect:/";
    }

}