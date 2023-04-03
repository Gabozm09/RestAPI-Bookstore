package ShoppingCart;

import java.math.BigDecimal;

public class ShoppingItemBuilder {
    private String id;
    private String name;
    private ItemType itemType;
    private BigDecimal price;

    public ShoppingItemBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ShoppingItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ShoppingItemBuilder setItemType(ShoppingCart.ItemType itemType) {
        this.itemType = itemType;
        return this;
    }

    public ShoppingItemBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Item createShoppingItem() {
        return new Item(id, name, itemType, price);
    }
}