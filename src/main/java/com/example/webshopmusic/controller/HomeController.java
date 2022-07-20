package com.example.webshopmusic.controller;

import com.example.webshopmusic.dataAccess.dao.IInstrumentDataAccess;
import com.example.webshopmusic.dataAccess.dao.ITCategoryDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value= "/home")
public class HomeController {

    private ITCategoryDataAccess tcategoryDAO;
    private IInstrumentDataAccess iInstrumentDAO;

    @Autowired
    public HomeController(ITCategoryDataAccess itCategoryDataAccess, IInstrumentDataAccess iInstrumentDAO) {
        this.tcategoryDAO = itCategoryDataAccess;
        this.iInstrumentDAO = iInstrumentDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home (Model model,@RequestParam(value = "locale", required = false) String param, @CookieValue(value = "localeCookie", defaultValue = "en") String cookie) {
        model.addAttribute("title", "Home Page");
        param = param == null ? "en" : param;
        model.addAttribute("listCategories", tcategoryDAO.getListTCategory(param) );
        model.addAttribute("listInstruments", iInstrumentDAO.getInstrumentsList() );
        return "integrated:home";
    }
}

