package mk.ukim.finki.emt.cdcatalog.services.form;

import lombok.Data;
import mk.ukim.finki.emt.cdcatalog.domain.models.Album;
import mk.ukim.finki.emt.cdcatalog.domain.models.Artist;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class CDForm {

    private String cdName;
    private Money price;
    private int sales;
    private Artist artist;
    private Album album;
}