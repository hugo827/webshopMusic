package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.dataAccess.entity.DiscountEntity;
import com.example.webshopmusic.dataAccess.entity.InstrumentEntity;
import com.example.webshopmusic.dataAccess.repository.IDiscountRepository;
import com.example.webshopmusic.dataAccess.repository.IInstrumentRepository;
import com.example.webshopmusic.dataAccess.util.ProviderConverter;
import com.example.webshopmusic.model.Discount;
import com.example.webshopmusic.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional
public class InstrumentDAO implements IInstrumentDataAccess {

    private ProviderConverter providerConverter;
    private IInstrumentRepository iInstrumentRepository;
    private IDiscountRepository iDiscountRepository;

    @Autowired
    public InstrumentDAO(ProviderConverter providerConverter, IInstrumentRepository iInstrumentRepository, IDiscountRepository iDiscountRepository) {
        this.providerConverter = providerConverter;
        this.iInstrumentRepository = iInstrumentRepository;
        this.iDiscountRepository = iDiscountRepository;
    }

    @Override
    public ArrayList<Instrument> getInstrumentsList(String category) {
        category = category.toLowerCase();
        List<InstrumentEntity> instrumentEntityList;
        if(category.equals("all"))instrumentEntityList = iInstrumentRepository.findAll();
        else instrumentEntityList = iInstrumentRepository.findInstrumentEntitiesByFkCategory(category);
        ArrayList<Instrument> instruments = new ArrayList<>();
        for(InstrumentEntity instrumentEntity : instrumentEntityList) {
            instruments.add(providerConverter.instrumentEntityToInstrumentModel(instrumentEntity));
        }
        for(Instrument instrument : instruments) {
            DiscountEntity discountEntity = iDiscountRepository.findByInstrumentDiscountIdEqualsAndStartAtLessThanEqualAndEndAtGreaterThan(instrument.getId(), new GregorianCalendar(), new GregorianCalendar());
            if(discountEntity != null) instrument.setDiscount(providerConverter.discountEntityToDiscountModel(discountEntity));
        }
        return instruments;
    }

    @Override
    public Instrument getInstrument(int idProduct) {
        InstrumentEntity instrumentEntity = iInstrumentRepository.findById(idProduct);
        if(instrumentEntity == null) return null;
        Instrument instrument = providerConverter.instrumentEntityToInstrumentModel(instrumentEntity);
        DiscountEntity discountEntity = iDiscountRepository.findByInstrumentDiscountIdEqualsAndStartAtLessThanEqualAndEndAtGreaterThan(instrument.getId(), new GregorianCalendar(), new GregorianCalendar());
        if(discountEntity != null) instrument.setDiscount(providerConverter.discountEntityToDiscountModel(discountEntity));
        return instrument;
    }
}
