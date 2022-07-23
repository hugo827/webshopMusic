package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.Order;

public interface IOrderDataAccess {
    Order save(Order order, CartSession cartSession);
}
