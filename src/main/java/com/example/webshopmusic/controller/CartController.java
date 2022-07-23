package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.model.CartItem;
import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.ProductAdd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value= "/cart")
@SessionAttributes({Constante.CURRENT_CART})
public class CartController {

    @RequestMapping(method = RequestMethod.GET)
    public String get (Model model, @ModelAttribute(value=Constante.CURRENT_CART) CartSession cartSession) {
        double totalPrice = 0.0;
        int totalProduct = 0;
        for(CartItem cartItem : cartSession.getCartSession().values()) {
            totalProduct += cartItem.getQuantity();
            totalPrice += cartItem.getInstrument().getPrice() * cartItem.getQuantity();
        }
        model.addAttribute("productAdd", new ProductAdd());
        model.addAttribute("totalProduct", totalProduct);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartList", cartSession.getCartSession());
        return "integrated:cart";
    }

    @RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
    public String remove(@PathVariable("id") int idProduct, @ModelAttribute(value = Constante.CURRENT_CART) CartSession cartSession) {
        cartSession.getCartSession().remove(idProduct);
        return "redirect:/cart";
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    public String update(@PathVariable("id") int idProduct,@ModelAttribute(value ="productAdd") ProductAdd productAdd, @ModelAttribute(value = Constante.CURRENT_CART) CartSession cartSession) {
        cartSession.getCartSession().get(idProduct).setQuantity(productAdd.getQuantity());
        return "redirect:/cart";
    }


}
