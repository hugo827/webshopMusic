package com.example.webshopmusic.dataAccess.repository;

import com.example.webshopmusic.dataAccess.entity.TCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITCategoryRepository  extends JpaRepository<TCategoryEntity, String> {
    @Query("Select id_translation, name, fk_category, fk_language FROM TCategoryEntity WHERE TCategoryEntity.fk_language.id_language = ?1 ")
    List<TCategoryEntity> findTCategoryEntitiesByFk_languageEquals(String language);
}
