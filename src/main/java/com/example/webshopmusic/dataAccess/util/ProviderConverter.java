package com.example.webshopmusic.dataAccess.util;

import com.example.webshopmusic.dataAccess.entity.InstrumentEntity;
import com.example.webshopmusic.dataAccess.entity.TCategoryEntity;
import com.example.webshopmusic.dataAccess.entity.UserEntity;
import com.example.webshopmusic.model.Instrument;
import com.example.webshopmusic.model.Tcategory;
import com.example.webshopmusic.model.User;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
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
        return  mapper.map(instrumentEntity, Instrument.class);
    }
}
