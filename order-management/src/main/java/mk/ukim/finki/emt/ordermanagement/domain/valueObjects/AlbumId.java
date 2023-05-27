package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AlbumId extends DomainObjectId {
    public AlbumId() {
        super(AlbumId.randomId(AlbumId.class).getId());
    }

    public AlbumId(String uuid) {
        super(uuid);
    }
}
