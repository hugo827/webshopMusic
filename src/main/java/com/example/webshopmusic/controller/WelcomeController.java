package com.example.webshopmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/hello")
public class WelcomeController {
    @RequestMapping(method=RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("age", 8);
        model.addAttribute("title", "Welcomme Page");
        return "integrated:welcome";
    }
}

