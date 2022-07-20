package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="brand")
public class BrandEntity {

    @Id
    @Column(name="id_brand")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idBrand;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="fkBrand", fetch=FetchType.LAZY)
    private Collection<InstrumentEntity> instruments;

    public BrandEntity() {
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<InstrumentEntity> getInstruments() {
        return instruments;
    }

    public void setInstruments(Collection<InstrumentEntity> instruments) {
        this.instruments = instruments;
    }
}
