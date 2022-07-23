package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.dataAccess.dao.IOrderDataAccess;
import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.Order;
import com.example.webshopmusic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value= "/order")
@SessionAttributes({Constante.CURRENT_CART})
public class OrderController {

    private IOrderDataAccess orderDAO;
    @Autowired
    public OrderController(IOrderDataAccess orderDAO) {
        this.orderDAO = orderDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@ModelAttribute(value = Constante.CURRENT_CART) CartSession cartSession) {
        if(cartSession.getCartSession().isEmpty()) return "redirect:/cart";
        return "integrated:confirmorder";
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String post(@ModelAttribute(value = Constante.CURRENT_CART) CartSession cartSession, Authentication authentication) {
        if(cartSession.getCartSession().isEmpty()) return "redirect:/cart";
        User user = (User) authentication.getPrincipal();
        Order order = new Order();
        order.setUser(user);
        order = orderDAO.save(order, cartSession);
        cartSession.getCartSession().clear();
        return "redirect:/home";
    }
}
