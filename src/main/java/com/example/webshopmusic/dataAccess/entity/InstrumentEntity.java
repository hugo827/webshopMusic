package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="instrument")
public class InstrumentEntity {

    @Id
    @Column(name="id_instrument")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
    @Column(name="fk_category")
    private String fkCategory;
    @JoinColumn(name="fk_brand", referencedColumnName="id_brand")
    @ManyToOne
    private BrandEntity fkBrand;

    @OneToMany(mappedBy="instrumentDiscount", fetch=FetchType.LAZY)
    private Collection<DiscountEntity> discounts;

    @OneToMany(mappedBy="instrumentOrderLine", fetch=FetchType.LAZY)
    private Collection<OrderLineEntity> orderLines;

    public InstrumentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(String fkCategory) {
        this.fkCategory = fkCategory;
    }

    public BrandEntity getFkBrand() {
        return fkBrand;
    }

    public void setFkBrand(BrandEntity fkBrand) {
        this.fkBrand = fkBrand;
    }

    public Collection<DiscountEntity> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Collection<DiscountEntity> discounts) {
        this.discounts = discounts;
    }

    public Collection<OrderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }
}
