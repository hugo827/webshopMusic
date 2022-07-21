package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.model.Instrument;

import java.util.ArrayList;

public interface IInstrumentDataAccess {

    ArrayList<Instrument> getInstrumentsList(String category);
    Instrument getInstrument(int idProduct);
}
