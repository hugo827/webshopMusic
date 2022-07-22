package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.dataAccess.dao.IInstrumentDataAccess;
import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.Instrument;
import com.example.webshopmusic.model.ProductAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value= "/product")
@SessionAttributes({Constante.CURRENT_CART})
public class ProductController {

    private IInstrumentDataAccess iInstrumentDataAccess;
    private  ProductAdd productAdd;

    @Autowired
    public ProductController(IInstrumentDataAccess iInstrumentDataAccess) {
        this.iInstrumentDataAccess = iInstrumentDataAccess;
        this.productAdd = new ProductAdd();
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
        productAdd.setInstrument(instrument);
        model.addAttribute("productAdd", productAdd);
        return "integrated:product";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String post(@ModelAttribute(value="productAdd") ProductAdd productAdd, @ModelAttribute(value = Constante.CURRENT_CART) CartSession cartSession, final BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            cartSession.addInstrument(this.productAdd.getInstrument().getId(), this.productAdd.getInstrument(), productAdd.getQuantity());
            return "redirect:/home";
        }
        return "integrated:product";
    }
}
