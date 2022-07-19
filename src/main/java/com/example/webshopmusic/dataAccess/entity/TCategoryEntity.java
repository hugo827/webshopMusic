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

    @JoinColumn(name="fk_category", referencedColumnName = "id_category")
    @ManyToOne
    private CategoryEntity fk_category;

    @JoinColumn(name="fk_language", referencedColumnName = "id_language")
    @ManyToOne
    private LanguageEntity fk_language;

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

    public CategoryEntity getFk_category() {
        return fk_category;
    }

    public void setFk_category(CategoryEntity fk_category) {
        this.fk_category = fk_category;
    }

    public LanguageEntity getFk_language() {
        return fk_language;
    }

    public void setFk_language(LanguageEntity fk_language) {
        this.fk_language = fk_language;
    }
}
