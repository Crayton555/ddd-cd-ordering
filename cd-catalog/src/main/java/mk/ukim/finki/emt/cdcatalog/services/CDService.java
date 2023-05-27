package mk.ukim.finki.emt.cdcatalog.services;

import mk.ukim.finki.emt.cdcatalog.domain.models.CD;
import mk.ukim.finki.emt.cdcatalog.domain.models.CDId;
import mk.ukim.finki.emt.cdcatalog.services.form.CDForm;

import java.util.List;

public interface CDService {

    CD findById(CDId id);

    CD createCD(CDForm form);

    CD orderItemCreated(CDId cdId, int quantity);

    CD orderItemRemoved(CDId cdId, int quantity);

    List<CD> getAll();
}