package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.CD;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private CD cd;

    @Min(1)
    private int quantity = 1;
}