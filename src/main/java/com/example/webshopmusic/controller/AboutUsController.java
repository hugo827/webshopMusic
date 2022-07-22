package com.example.webshopmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/aboutus")
public class AboutUsController {

    @RequestMapping(method = RequestMethod.GET)
    public String get (Model model) {
        return "integrated:aboutus";
    }
}
