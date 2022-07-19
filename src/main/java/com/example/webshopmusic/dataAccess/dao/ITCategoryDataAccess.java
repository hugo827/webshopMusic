package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.model.Tcategory;

import java.util.ArrayList;

public interface ITCategoryDataAccess {

    ArrayList<Tcategory> getListTCategory(String language);
    
}
