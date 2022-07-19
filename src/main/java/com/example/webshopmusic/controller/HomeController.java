package com.example.webshopmusic.controller;

import com.example.webshopmusic.dataAccess.dao.ITCategoryDataAccess;
import com.example.webshopmusic.dataAccess.dao.IUserDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/home")
public class HomeController {

    private ITCategoryDataAccess tcategoryDAO;

    @Autowired
    public HomeController(ITCategoryDataAccess itCategoryDataAccess) {
        this.tcategoryDAO = itCategoryDataAccess;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("title", "Home Page");
        model.addAttribute("listCategories", tcategoryDAO.getListTCategory("fr") );
        return "integrated:home";
    }
}

