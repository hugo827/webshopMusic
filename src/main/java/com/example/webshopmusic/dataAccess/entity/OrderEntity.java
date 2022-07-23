package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.GregorianCalendar;

@Entity
@Table(name="`order`")
public class OrderEntity {

    @Id
    @Column(name="id_order")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idOrder;

    @Column(name="ordered_at")
    private GregorianCalendar orderedAt;

    @Column(name="is_paid")
    private Boolean isPaid;

    @JoinColumn(name="fk_customer", referencedColumnName="id_customer")
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy="order", fetch=FetchType.LAZY)
    private Collection<OrderLineEntity> orderLineEntities;

    public OrderEntity() {
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

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Collection<OrderLineEntity> getOrderLineEntities() {
        return orderLineEntities;
    }

    public void setOrderLineEntities(Collection<OrderLineEntity> orderLineEntities) {
        this.orderLineEntities = orderLineEntities;
    }
}
