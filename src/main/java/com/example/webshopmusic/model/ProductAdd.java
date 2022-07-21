package com.example.webshopmusic.model;

public class ProductAdd {

    private Instrument instrument;
    private int quantity;

    public ProductAdd(Instrument instrument) {
        this.instrument = instrument;
    }

    public ProductAdd() {
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
