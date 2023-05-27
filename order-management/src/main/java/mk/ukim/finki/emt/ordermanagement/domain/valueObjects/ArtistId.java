package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArtistId extends DomainObjectId {
    public ArtistId() {
        super(ArtistId.randomId(ArtistId.class).getId());
    }

    public ArtistId(String uuid) {
        super(uuid);
    }
}
