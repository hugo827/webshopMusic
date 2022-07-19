package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class LanguageEntity {
    @Id
    @Column(name="id_language")
    private String id_language;

    public LanguageEntity() {
    }

    public String getId_language() {
        return id_language;
    }

    public void setId_language(String id_language) {
        this.id_language = id_language;
    }
}
