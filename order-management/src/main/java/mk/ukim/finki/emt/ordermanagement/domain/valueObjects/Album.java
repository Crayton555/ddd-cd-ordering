package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Album implements ValueObject {
    private final AlbumId id;
    private final String name;
    private final int releaseYear;
    private final String albumArtwork;

    private Album() {
        this.id = AlbumId.randomId(AlbumId.class);
        this.name = "";
        this.releaseYear = 0;
        this.albumArtwork = "";
    }

    @JsonCreator
    public Album(@JsonProperty("id") AlbumId id,
                 @JsonProperty("albumName") String name,
                 @JsonProperty("releaseYear") int releaseYear,
                 @JsonProperty("albumArtwork") String albumArtwork) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.albumArtwork = albumArtwork;
    }
}
