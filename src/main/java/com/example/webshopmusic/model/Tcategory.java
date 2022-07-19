package com.example.webshopmusic.model;

public class Tcategory {

    private String name;
    private String fk_category;
    private String fk_language;

    public Tcategory(String name, String fk_category, String fk_language) {
        this.name = name;
        this.fk_category = fk_category;
        this.fk_language = fk_language;
    }

    public Tcategory() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFk_category() {
        return fk_category;
    }

    public void setFk_category(String fk_category) {
        this.fk_category = fk_category;
    }

    public String getFk_language() {
        return fk_language;
    }

    public void setFk_language(String fk_language) {
        this.fk_language = fk_language;
    }
}
