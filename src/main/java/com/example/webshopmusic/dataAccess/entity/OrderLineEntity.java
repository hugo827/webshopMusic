package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="orderline")
public class OrderLineEntity {

    @Id
    @Column(name="id_orderline")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idOrderline;

    @Column(name="price_product")
    private double priceProduct;

    @Column(name="quantity")
    private int quantity;

    @Column(name="percentage_discount")
    private double percentageQuantity;

    @JoinColumn(name="fk_order", referencedColumnName="id_order")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name="fk_instrument", referencedColumnName="id_instrument")
    @ManyToOne
    private InstrumentEntity instrumentOrderLine;


    public OrderLineEntity() {
    }

    public int getIdOrderline() {
        return idOrderline;
    }

    public void setIdOrderline(int idOrderline) {
        this.idOrderline = idOrderline;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPercentageQuantity() {
        return percentageQuantity;
    }

    public void setPercentageQuantity(double percentageQuantity) {
        this.percentageQuantity = percentageQuantity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public InstrumentEntity getInstrument() {
        return instrumentOrderLine;
    }

    public void setInstrument(InstrumentEntity instrument) {
        this.instrumentOrderLine = instrument;
    }
}
