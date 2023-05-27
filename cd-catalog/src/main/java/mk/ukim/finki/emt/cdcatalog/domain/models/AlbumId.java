package mk.ukim.finki.emt.cdcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class AlbumId extends DomainObjectId {
    public AlbumId() {
        super(AlbumId.randomId(AlbumId.class).getId());
    }

    public AlbumId(@NonNull String uuid) {
        super(uuid);
    }

    public static AlbumId of(String uuid) {
        AlbumId album = new AlbumId(uuid);
        return album;
    }
}
