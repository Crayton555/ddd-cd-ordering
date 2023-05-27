package mk.ukim.finki.emt.cdcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ArtistId extends DomainObjectId {
    public ArtistId() {
        super(ArtistId.randomId(ArtistId.class).getId());
    }

    public ArtistId(@NonNull String uuid) {
        super(uuid);
    }

    public static ArtistId of(String uuid) {
        ArtistId artist = new ArtistId(uuid);
        return artist;
    }
}
