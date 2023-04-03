package ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder
public class Item {

    private  String id;
    private String name;
    private  ItemType itemType;
    private  BigDecimal price;



    public Item(String id, String name, ItemType itemType, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.price = price;

    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public BigDecimal getPrice() {
        return price;
    }

}




