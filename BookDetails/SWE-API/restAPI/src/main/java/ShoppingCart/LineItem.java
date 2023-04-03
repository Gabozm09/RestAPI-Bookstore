package ShoppingCart;
public class LineItem {
    private  String itemId;
     private int quantity;

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
}
