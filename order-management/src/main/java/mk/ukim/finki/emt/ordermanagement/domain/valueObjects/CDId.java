package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CDId extends DomainObjectId {

    public CDId() {
        super(CDId.randomId(CDId.class).getId());
    }

    public CDId(String uuid) {
        super(uuid);
    }
}

