package mk.ukim.finki.emt.ordermanagement.domain.models;

import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.CDId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "cd_id", nullable = false))
    private CDId cdId;

    public OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull CDId cdId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.cdId = cdId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }
}