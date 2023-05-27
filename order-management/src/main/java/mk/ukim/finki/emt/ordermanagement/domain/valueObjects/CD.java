package mk.ukim.finki.emt.ordermanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class CD implements ValueObject {
    private final CDId id;
    private final String name;
    private final Money price;
    private final int sales;
    private final Artist artist;
    private final Album album;

    private CD() {
        this.id = CDId.randomId(CDId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);
        this.sales = 0;
        this.artist = null;
        this.album = null;
    }

    @JsonCreator
    public CD(@JsonProperty("id") CDId id,
              @JsonProperty("cdName") String name,
              @JsonProperty("price") Money price,
              @JsonProperty("sales") int sales,
              @JsonProperty("artist") Artist artist,
              @JsonProperty("album") Album album) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.artist = artist;
        this.album = album;
    }

}
