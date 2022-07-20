package com.example.webshopmusic.controller;

import com.example.webshopmusic.dataAccess.dao.IInstrumentDataAccess;
import com.example.webshopmusic.dataAccess.repository.IInstrumentRepository;
import com.example.webshopmusic.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value= "/product")
public class ProductController {

    private IInstrumentDataAccess iInstrumentDataAccess;

    @Autowired
    public ProductController(IInstrumentDataAccess iInstrumentDataAccess) {
        this.iInstrumentDataAccess = iInstrumentDataAccess;
    }

    @RequestMapping(value={"/{id}"}, method= RequestMethod.GET)
    public String get(@PathVariable("id") int idProduct,  Model model) {
        model.addAttribute("title", "Product Page");
        Instrument instrument = iInstrumentDataAccess.getInstrument(idProduct);
        if(instrument == null)  {
            model.addAttribute("message", "The product you ask doesn't exist");
            return "integrated:error";
        }
        model.addAttribute("product", instrument);
        return "integrated:product";
    }

}
