package mk.ukim.finki.emt.cdcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.cdcatalog.domain.models.CDId;
import mk.ukim.finki.emt.cdcatalog.services.CDService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CDEventListener {

    private final CDService cdService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "cdCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            cdService.orderItemCreated(CDId.of(event.getCdId()), event.getQuantity());
        } catch (Exception e) {

        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "cdCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage, OrderItemRemoved.class);
            cdService.orderItemRemoved(CDId.of(event.getCdId()), event.getQuantity());
        } catch (Exception e) {

        }
    }
}