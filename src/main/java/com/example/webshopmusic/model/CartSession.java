package com.example.webshopmusic.model;

import java.util.HashMap;
import java.util.Map;

public class CartSession {

    private HashMap<Integer, CartItem> cartSession;

    public CartSession() {
        cartSession = new HashMap<>();
    }

    public HashMap<Integer, CartItem> getCartSession() {
        return cartSession;
    }

   public void addInstrument(int idInstrument, Instrument instrument, int quantity) {
        if(cartSession.containsKey(idInstrument)) cartSession.get(idInstrument).setQuantity(cartSession.get(idInstrument).getQuantity() + quantity);
        else {
            cartSession.put(idInstrument, new CartItem(instrument, quantity));
        }
   }

}
