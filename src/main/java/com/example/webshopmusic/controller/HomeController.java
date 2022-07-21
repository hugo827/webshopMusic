package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.dataAccess.dao.IInstrumentDataAccess;
import com.example.webshopmusic.dataAccess.dao.ITCategoryDataAccess;
import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value= "/home")
@SessionAttributes({Constante.CURRENT_CART})
public class HomeController {

    private ITCategoryDataAccess tcategoryDAO;
    private IInstrumentDataAccess iInstrumentDAO;

    @Autowired
    public HomeController(ITCategoryDataAccess itCategoryDataAccess, IInstrumentDataAccess iInstrumentDAO) {
        this.tcategoryDAO = itCategoryDataAccess;
        this.iInstrumentDAO = iInstrumentDAO;
    }

    @ModelAttribute(Constante.CURRENT_CART)
    public CartSession cartSession() {
        return new CartSession();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home () {
        return "redirect:/home/all";
    }

    @RequestMapping(value={"/{category}"}, method= RequestMethod.GET)
    public String get(@PathVariable("category") String cat,  Model model, @RequestParam(value = "locale", required = false) String param,
                      @CookieValue(value = "localeCookie", defaultValue = "en") String cookie,
                      @ModelAttribute(value=Constante.CURRENT_CART) CartSession cartSession
    ) {
        model.addAttribute("title", "Product Page ");
        param = param == null ? cookie : param;
        param = !param.equals("fr") && !param.equals("en") ? "en" : param;
        model.addAttribute("listCategories", tcategoryDAO.getListTCategory(param) );
        model.addAttribute("listInstruments", iInstrumentDAO.getInstrumentsList(cat));
        return "integrated:home";
    }
}

