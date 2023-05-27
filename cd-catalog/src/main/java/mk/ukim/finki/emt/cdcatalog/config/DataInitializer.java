package mk.ukim.finki.emt.cdcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.cdcatalog.domain.models.Album;
import mk.ukim.finki.emt.cdcatalog.domain.models.Artist;
import mk.ukim.finki.emt.cdcatalog.domain.models.CD;
import mk.ukim.finki.emt.cdcatalog.domain.repository.AlbumRepository;
import mk.ukim.finki.emt.cdcatalog.domain.repository.ArtistRepository;
import mk.ukim.finki.emt.cdcatalog.domain.repository.CDRepository;
import mk.ukim.finki.emt.cdcatalog.xport.rest.CDResource;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final CDRepository cdRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    @PostConstruct
    public void initData() {
        Artist artist1 = Artist.build("Mick Jagger", "Sir Michael Philip Jagger is an English singer and songwriter who has achieved international fame as the lead vocalist and one of the founder members of the rock band the Rolling Stones.");
        if (artistRepository.findAll().isEmpty()) {
            artistRepository.save(artist1);
        }

        Album album1 = Album.build("Aftermath", 1966, "Artowrk For Aftermath");
        if (albumRepository.findAll().isEmpty()) {
            albumRepository.save(album1);
        }

        CD cd1 = CD.build("Rolling Stones Greatest Hits", Money.valueOf(Currency.MKD, 500), 10, artist1, album1);
        CD cd2 = CD.build("Aftermath CD", Money.valueOf(Currency.MKD, 100), 5, artist1, album1);
        if (cdRepository.findAll().isEmpty()) {
            cdRepository.saveAll(Arrays.asList(cd1, cd2));
        }
    }
}