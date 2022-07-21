package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name="discount")
public class DiscountEntity {

    @Id
    @Column(name="id_discount")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idDiscount;

    @Column(name="percentage_discount")
    private double percentageDiscount;

    @Column(name="start_at")
    private GregorianCalendar startAt;

    @Column(name="end_at")
    private GregorianCalendar endAt;

    @JoinColumn(name="fK_instrument", referencedColumnName="id_instrument")
    @ManyToOne
    private InstrumentEntity instrumentDiscount;

    public DiscountEntity() {
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
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

    public InstrumentEntity getInstrument() {
        return instrumentDiscount;
    }

    public void setInstrument(InstrumentEntity instrument) {
        this.instrumentDiscount = instrument;
    }
}
