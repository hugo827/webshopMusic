package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.InstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstrumentRepository extends JpaRepository<InstrumentEntity, Integer> {

    InstrumentEntity findById(int id);
}
