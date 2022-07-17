package com.example.webshopmusic.controller;

import com.example.webshopmusic.dataAccess.dao.IUserDataAccess;
import com.example.webshopmusic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/home")
public class HomeController {

    private IUserDataAccess userDAO;

    @Autowired
    public HomeController(IUserDataAccess iUserDataAccess) {
        this.userDAO = iUserDataAccess;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("age", 8);
        model.addAttribute("title", "Home Page");
        model.addAttribute("users", userDAO.getAllUser() );
        User user = userDAO.findByUsername("admin");
        model.addAttribute("userName", user.getEmail());
        return "integrated:home";
    }
}

