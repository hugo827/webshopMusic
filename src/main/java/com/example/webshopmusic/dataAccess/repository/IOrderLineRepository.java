package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderLineRepository extends JpaRepository<OrderLineEntity, Integer> {

}
