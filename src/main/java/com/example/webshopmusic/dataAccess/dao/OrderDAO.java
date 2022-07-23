package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.dataAccess.entity.OrderEntity;
import com.example.webshopmusic.dataAccess.entity.OrderLineEntity;
import com.example.webshopmusic.dataAccess.repository.IOrderLineRepository;
import com.example.webshopmusic.dataAccess.repository.IOrderRepository;
import com.example.webshopmusic.dataAccess.util.ProviderConverter;
import com.example.webshopmusic.model.CartItem;
import com.example.webshopmusic.model.CartSession;
import com.example.webshopmusic.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDAO implements IOrderDataAccess {

    private ProviderConverter providerConverter;
    private IOrderRepository iOrderRepository;
    private IOrderLineRepository iOrderLineRepository;

    @Autowired
    public OrderDAO(ProviderConverter providerConverter, IOrderRepository iOrderRepository, IOrderLineRepository iOrderLineRepository) {
        this.providerConverter = providerConverter;
        this.iOrderRepository = iOrderRepository;
        this.iOrderLineRepository = iOrderLineRepository;
    }
    @Override
    public Order save(Order order, CartSession cartSession) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderEntity = iOrderRepository.save(orderEntity);

        for(CartItem c : cartSession.getCartSession().values()) {
            OrderLineEntity orderLineEntity = new OrderLineEntity();
            orderLineEntity.setOrder(orderEntity);
            orderLineEntity.setInstrument(providerConverter.instrumentModelToInstrumentEntity(c.getInstrument()));
            orderLineEntity.setQuantity(c.getQuantity());
            orderLineEntity.setPriceProduct(c.getInstrument().getPrice());
            orderLineEntity.setPercentageQuantity(c.getInstrument().getDiscount().getPercentageDiscount());
            orderLineEntity = iOrderLineRepository.save(orderLineEntity);
        }

        return providerConverter.orderEntityToOrderModel(orderEntity);
    }
}
