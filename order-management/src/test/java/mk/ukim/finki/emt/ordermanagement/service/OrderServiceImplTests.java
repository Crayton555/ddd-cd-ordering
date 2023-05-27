package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.models.Order;
import mk.ukim.finki.emt.ordermanagement.domain.models.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.*;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.forms.OrderItemForm;
import mk.ukim.finki.emt.ordermanagement.xport.client.CDClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CDClient cdClient;

    private static CD newCd(String name, Money price) {
        Artist artist = newArtist("Phil Collins", "Description for Phil Collins");
        Album album = newAlbum("Rock Line, Vol. 4", 2004, "Album Artwork");
        CD cd = new CD(CDId.randomId(CDId.class), name, price, 0, artist, album);
        return cd;
    }

    private static Artist newArtist(String name, String description) {
        Artist artist = new Artist(ArtistId.randomId(ArtistId.class), name, description);
        return artist;
    }

    private static Album newAlbum(String name, int releaseYear, String albumArtwork) {
        Album album = new Album(AlbumId.randomId(AlbumId.class), name, releaseYear, albumArtwork);
        return album;
    }

    @Test
    public void testPlaceOrder() {

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setCd(newCd("Aftermath", Money.valueOf(Currency.MKD, 1500)));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setCd(newCd("Hindsight", Money.valueOf(Currency.MKD, 500)));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);
        Assertions.assertEquals(newOrder.total(), Money.valueOf(Currency.MKD, 2500));

    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<CD> cdList = cdClient.findAll();
        CD cd1 = cdList.get(0);
        CD cd2 = cdList.get(1);

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setCd(cd1);
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setCd(cd2);
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdNotExistException::new);

        Money outMoney = cd1.getPrice().multiply(oi1.getQuantity()).add(cd2.getPrice().multiply(oi2.getQuantity()));
        Assertions.assertEquals(newOrder.total(), outMoney);
    }

}