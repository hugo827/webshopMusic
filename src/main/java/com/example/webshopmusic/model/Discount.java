package com.example.webshopmusic.model;

import java.util.GregorianCalendar;

public class Discount {

    private int id;
    private GregorianCalendar startAt;
    private GregorianCalendar endAt;
    private double percentageDiscount;

    public Discount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getStartAt() {
        return startAt;
    }

    public void setStartAt(GregorianCalendar startAt) {
        this.startAt = startAt;
    }

    public GregorianCalendar getEndAt() {
        return endAt;
    }

    public void setEndAt(GregorianCalendar endAt) {
        this.endAt = endAt;
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
}
