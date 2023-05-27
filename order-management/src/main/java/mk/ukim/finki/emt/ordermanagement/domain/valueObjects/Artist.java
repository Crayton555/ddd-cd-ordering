package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Artist implements ValueObject {
    private final ArtistId id;
    private final String name;
    private final String description;

    private Artist() {
        this.id = ArtistId.randomId(ArtistId.class);
        this.name = "";
        this.description = "";
    }

    @JsonCreator
    public Artist(@JsonProperty("id") ArtistId id,
                  @JsonProperty("artistName") String name,
                  @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
