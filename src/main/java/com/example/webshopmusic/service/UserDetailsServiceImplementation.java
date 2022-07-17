package com.example.webshopmusic.service;

import com.example.webshopmusic.dataAccess.dao.IUserDataAccess;
import com.example.webshopmusic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplementation implements UserDetailsService {

    private IUserDataAccess userDAO;

    @Autowired
    public UserDetailsServiceImplementation(IUserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("user not found");
    }
}
