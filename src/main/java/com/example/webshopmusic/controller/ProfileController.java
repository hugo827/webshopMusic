package com.example.webshopmusic.controller;

import com.example.webshopmusic.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String get (Authentication authentication, Model model) {
        User u = (User)  authentication.getPrincipal();
        model.addAttribute("user", u);
        return "integrated:profile";
    }
}