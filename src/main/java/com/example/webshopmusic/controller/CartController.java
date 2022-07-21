package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.model.CartSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value= "/cart")
@SessionAttributes({Constante.CURRENT_CART})
public class CartController {

    @RequestMapping(method = RequestMethod.GET)
    public String get (Model model, @ModelAttribute(value=Constante.CURRENT_CART) CartSession cartSession) {
        model.addAttribute("cartList", cartSession.getCartSession());
        return "integrated:cart";
    }
}
