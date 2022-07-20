package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.TCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITCategoryRepository  extends JpaRepository<TCategoryEntity, Integer> {

    List<TCategoryEntity> findTCategoryEntitiesByFkLanguageEquals(String language);

}
