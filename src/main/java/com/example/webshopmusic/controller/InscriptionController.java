package com.example.webshopmusic.controller;

import com.example.webshopmusic.ConstanteApp.Constante;
import com.example.webshopmusic.dataAccess.dao.IUserDataAccess;
import com.example.webshopmusic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value= "/inscription")
@SessionAttributes({Constante.CURRENT_USER})
public class InscriptionController {

    private IUserDataAccess userDAO;

    @Autowired
    public InscriptionController(IUserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constante.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String get (Model model) {
        model.addAttribute("currentUser", user());
        return "integrated:inscription";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String post(Model model, @Valid @ModelAttribute(value = Constante.CURRENT_USER)  User user, final BindingResult bindingResult) {
        //TODO: a voir --> pas correct
        user.setAuthorities("ROLE_USER");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        user.setPassword(b.encode(user.getPassword()));

        if (!bindingResult.hasErrors()) {
            user = userDAO.save(user);
            return "redirect:/login";
        }
        return "integrated:inscription";
    }
}
