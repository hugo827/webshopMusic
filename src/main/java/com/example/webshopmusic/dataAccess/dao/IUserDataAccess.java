package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.model.User;

import java.util.ArrayList;

public interface IUserDataAccess {

    User save(User user);

    User findByUsername(String username);

    ArrayList<User> getAllUser();
}
