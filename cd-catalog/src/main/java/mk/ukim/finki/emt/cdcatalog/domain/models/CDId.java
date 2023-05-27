package mk.ukim.finki.emt.cdcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class CDId extends DomainObjectId {
    public CDId() {
        super(CDId.randomId(CDId.class).getId());
    }

    public CDId(@NonNull String uuid) {
        super(uuid);
    }

    public static CDId of(String uuid) {
        CDId cd = new CDId(uuid);
        return cd;
    }
}