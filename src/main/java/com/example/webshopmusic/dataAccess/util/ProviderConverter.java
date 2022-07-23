package com.example.webshopmusic.dataAccess.util;

import com.example.webshopmusic.dataAccess.entity.*;
import com.example.webshopmusic.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();


    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setAuthorities(userEntity.getAuthorities());
        return user;
    }

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setAccountNonExpired(user.getAccountNonExpired());
        userEntity.setAccountNonLocked(user.getAccountNonLocked());
        userEntity.setEnabled(user.getEnabled());
        userEntity.setCredentialsNonExpired(user.getCredentialsNonExpired());
        userEntity.setAuthorities(user.getAuthorities().toString());
        return userEntity;
    }

    public TCategoryEntity tCategoryModelToTCategoryEntity(Tcategory tcategory) {
        return mapper.map(tcategory, TCategoryEntity.class);
    }

    public Tcategory tcategoryEntityToTCategoryModel(TCategoryEntity tcategoryEntity) {
        return mapper.map(tcategoryEntity, Tcategory.class);
    }

    public InstrumentEntity instrumentModelToInstrumentEntity(Instrument instrument) {
        return mapper.map(instrument, InstrumentEntity.class);
    }

    public Instrument instrumentEntityToInstrumentModel(InstrumentEntity instrumentEntity) {
        Instrument instrument = mapper.map(instrumentEntity, Instrument.class);
        instrument.setBrand(brandEntityToBrandModel(instrumentEntity.getFkBrand()));
        return  instrument;
    }

    private Brand brandEntityToBrandModel(BrandEntity brandEntity) {
        return mapper.map(brandEntity, Brand.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        orderEntity.setIsPaid(order.getPaid());
        orderEntity.setOrderedAt(order.getOrderedAt());
        orderEntity.setUser(userModelToUserEntity(order.getUser()));
        return orderEntity;
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        Order order = mapper.map(orderEntity, Order.class);
        order.setPaid(orderEntity.getIsPaid());
        order.setOrderedAt(orderEntity.getOrderedAt());
        order.setUser(userEntityToUserModel(orderEntity.getUser()));
        return order;
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity) {
        Discount discount = mapper.map(discountEntity, Discount.class);
        discount.setPercentageDiscount(discountEntity.getPercentageDiscount());
        discount.setEndAt(discountEntity.getEndAt());
        discount.setStartAt(discountEntity.getStartAt());
        return discount;
    }
}
