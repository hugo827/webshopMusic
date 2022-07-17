package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String userName);
}
