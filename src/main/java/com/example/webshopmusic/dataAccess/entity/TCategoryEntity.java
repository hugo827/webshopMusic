package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="tcategory")
public class TCategoryEntity {

    @Id
    @Column(name="id_translation")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_translation;

    @Column(name="name")
    private String name;

    @Column(name="fk_category")
    private String fkCategory;

    @Column(name="fk_language")
    private String fkLanguage;

    public TCategoryEntity() {
    }

    public int getId_translation() {
        return id_translation;
    }

    public void setId_translation(int id_translation) {
        this.id_translation = id_translation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFk_category() {
        return fkCategory;
    }

    public void setFk_category(String fk_category) {
        this.fkCategory = fk_category;
    }

    public String getFk_language() {
        return fkLanguage;
    }

    public void setFk_language(String fk_language) {
        this.fkLanguage = fk_language;
    }
}
