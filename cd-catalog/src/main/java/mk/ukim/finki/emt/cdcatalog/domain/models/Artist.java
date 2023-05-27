package mk.ukim.finki.emt.cdcatalog.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
@Getter
public class Artist extends AbstractEntity<ArtistId> {
    private String artistName;
    private String description;

    public Artist() {
        super(ArtistId.randomId(ArtistId.class));
    }

    public static Artist build(String artistName, String description) {
        Artist artist = new Artist();
        artist.artistName = artistName;
        artist.description = description;
        return artist;
    }
}
