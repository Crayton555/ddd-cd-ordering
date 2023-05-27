package mk.ukim.finki.emt.cdcatalog.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Getter;
import mk.ukim.finki.emt.cdcatalog.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name = "cd")
@Getter
public class CD extends AbstractEntity<CDId> {

    private String cdName;

    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;
    @OneToOne
    private Artist artist;
    @OneToOne
    private Album album;

    public CD() {
        super(CDId.randomId(CDId.class));
    }

    public static CD build(String cdName, Money price, int sales, Artist artist, Album album) {
        CD cd = new CD();
        cd.price = price;
        cd.cdName = cdName;
        cd.sales = sales;
        cd.artist = artist;
        cd.album = album;
        return cd;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }
}
