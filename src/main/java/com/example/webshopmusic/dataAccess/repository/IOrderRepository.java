package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {

}
