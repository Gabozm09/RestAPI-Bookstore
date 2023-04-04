package ShoppingCart;

import java.math.BigDecimal;
import java.util.Objects;

public class LineItem {
   private  String itemId;
   private int quantity;

   private String name;

   private BigDecimal price;

    public LineItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public LineItem(String item) {
        this(item, 1);

    }
    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineItem lineItem)) return false;

        if (quantity != lineItem.quantity) return false;
        return Objects.equals(itemId, lineItem.itemId);
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }

    public void reduceQuantityBy(int quantityToReduceBy) {
        this.quantity -= quantityToReduceBy;
    }
    public BigDecimal totalPrice(){
        return  price.multiply(BigDecimal.valueOf(quantity));
    }

    public void increaseQuantityBy(int quantityToAdd) {
        this.quantity += quantityToAdd;

    }
}
