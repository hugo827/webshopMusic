package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.DiscountEntity;
import com.example.webshopmusic.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.GregorianCalendar;

@Repository
public interface IDiscountRepository extends JpaRepository<DiscountEntity, Integer> {

//    @Query("SELECT d.idDiscount,d.percentageDiscount, d.endAt, d.startAt, d.instrumentDiscount  FROM DiscountEntity d WHERE d.instrumentDiscount.id = ?1 AND ?2 BETWEEN d.startAt and d.endAt ")
//    DiscountEntity findDiscountEntity(Integer fkInstrument, GregorianCalendar today);

    DiscountEntity findByInstrumentDiscountIdEqualsAndStartAtLessThanEqualAndEndAtGreaterThan(int instrument, GregorianCalendar date, GregorianCalendar date2);

    }
