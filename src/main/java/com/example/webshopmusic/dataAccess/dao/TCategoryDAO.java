package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.dataAccess.entity.TCategoryEntity;
import com.example.webshopmusic.dataAccess.repository.ITCategoryRepository;
import com.example.webshopmusic.dataAccess.util.ProviderConverter;
import com.example.webshopmusic.model.Tcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TCategoryDAO implements ITCategoryDataAccess {

    private ITCategoryRepository itCategoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TCategoryDAO(ITCategoryRepository itCategoryRepository, ProviderConverter providerConverter) {
        this.itCategoryRepository = itCategoryRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public ArrayList<Tcategory> getListTCategory(String language) {
        List<TCategoryEntity> tCategoryEntities = itCategoryRepository.findTCategoryEntitiesByFk_languageEquals(language);
        ArrayList<Tcategory> tcategories = new ArrayList<>();
        for(TCategoryEntity tCategoryEntity : tCategoryEntities) {
            tcategories.add(providerConverter.tcategoryEntityToTCategoryModel(tCategoryEntity));
        }
        return tcategories;
    }
}
