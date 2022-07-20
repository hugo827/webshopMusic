package com.example.webshopmusic.dataAccess.dao;

import com.example.webshopmusic.dataAccess.entity.InstrumentEntity;
import com.example.webshopmusic.dataAccess.repository.IInstrumentRepository;
import com.example.webshopmusic.dataAccess.util.ProviderConverter;
import com.example.webshopmusic.model.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InstrumentDAO implements IInstrumentDataAccess {

    private ProviderConverter providerConverter;
    private IInstrumentRepository iInstrumentRepository;

    @Autowired
    public InstrumentDAO(ProviderConverter providerConverter, IInstrumentRepository iInstrumentRepository) {
        this.providerConverter = providerConverter;
        this.iInstrumentRepository = iInstrumentRepository;
    }

    @Override
    public ArrayList<Instrument> getInstrumentsList() {
        List<InstrumentEntity> instrumentEntityList = iInstrumentRepository.findAll();
        ArrayList<Instrument> instruments = new ArrayList<>();
        for(InstrumentEntity instrumentEntity : instrumentEntityList) {
            instruments.add(providerConverter.instrumentEntityToInstrumentModel(instrumentEntity));
        }
        return instruments;
    }

    @Override
    public Instrument getInstrument(int idProduct) {
        InstrumentEntity instrumentEntity = iInstrumentRepository.findById(idProduct);
        return instrumentEntity == null ? null : providerConverter.instrumentEntityToInstrumentModel(instrumentEntity);
    }
}
