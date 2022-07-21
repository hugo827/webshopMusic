package com.example.webshopmusic.model;

public class CartItem {

    private Instrument instrument;
    private int quantity;

    public CartItem(Instrument instrument, int quantity) {
        this.instrument = instrument;
        this.quantity = quantity;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
