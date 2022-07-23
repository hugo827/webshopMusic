package com.example.webshopmusic.model;

import java.util.GregorianCalendar;

public class Order {

    private int idOrder;
    private GregorianCalendar orderedAt;
    private Boolean isPaid;
    private User user;
    public Order() {
        setOrderedAt(new GregorianCalendar());
        setPaid(false);
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public GregorianCalendar getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(GregorianCalendar orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
