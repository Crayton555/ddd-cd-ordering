package mk.ukim.finki.emt.cdcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.cdcatalog.domain.exceptions.CDNotFoundException;
import mk.ukim.finki.emt.cdcatalog.domain.models.CD;
import mk.ukim.finki.emt.cdcatalog.domain.models.CDId;
import mk.ukim.finki.emt.cdcatalog.domain.repository.CDRepository;
import mk.ukim.finki.emt.cdcatalog.services.CDService;
import mk.ukim.finki.emt.cdcatalog.services.form.CDForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CDServiceImpl implements CDService {

    private final CDRepository cdRepository;

    @Override
    public CD findById(CDId id) {
        return cdRepository.findById(id).orElseThrow(CDNotFoundException::new);
    }

    @Override
    public CD createCD(CDForm form) {
        CD cd = CD.build(form.getCdName(), form.getPrice(), form.getSales(), form.getArtist(), form.getAlbum());
        cdRepository.save(cd);
        return cd;
    }

    @Override
    public CD orderItemCreated(CDId cdId, int quantity) {
        CD cd = cdRepository.findById(cdId).orElseThrow(CDNotFoundException::new);
        cd.addSales(quantity);
        cdRepository.saveAndFlush(cd);
        return cd;
    }

    @Override
    public CD orderItemRemoved(CDId cdId, int quantity) {
        CD cd = cdRepository.findById(cdId).orElseThrow(CDNotFoundException::new);
        cd.removeSales(quantity);
        cdRepository.saveAndFlush(cd);
        return cd;
    }

    @Override
    public List<CD> getAll() {
        return cdRepository.findAll();
    }
}