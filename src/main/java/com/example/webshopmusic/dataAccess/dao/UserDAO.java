package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.dataAccess.entity.UserEntity;
import com.example.webshopmusic.dataAccess.repository.IUserRepository;
import com.example.webshopmusic.dataAccess.util.ProviderConverter;
import com.example.webshopmusic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO implements IUserDataAccess{

    private IUserRepository iUserRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(IUserRepository iUserRepository, ProviderConverter providerConverter) {
        this.iUserRepository = iUserRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByUsername(String userName) {
        return providerConverter.userEntityToUserModel(iUserRepository.findByUsername(userName));
    }

    public ArrayList<User> getAllUser() {
        List<UserEntity> userEntityList = iUserRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for(UserEntity userEntity : userEntityList ) {
            User user = providerConverter.userEntityToUserModel(userEntity);
            users.add(user);
        }
        return users;
    }
}
