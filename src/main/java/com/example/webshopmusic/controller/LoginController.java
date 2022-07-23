package com.example.webshopmusic.controller;

import com.example.webshopmusic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/login")

public class LoginController {

    @RequestMapping(method= RequestMethod.GET)
    public String get (Model model) {
        model.addAttribute("userModel", new User());
        return "integrated:login";
    }

}