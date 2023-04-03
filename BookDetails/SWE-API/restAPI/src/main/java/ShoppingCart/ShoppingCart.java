package ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<LineItem> itemsInCart = new ArrayList<>();

    public void addItem(LineItem lineItem) {
        this.itemsInCart.add(lineItem);

    }

    public int totalNumberOfItems() {
        int totalItems = 0;
        for(LineItem ShoppingLineItem : itemsInCart) {
            totalItems += ShoppingLineItem.getQuantity();
        }
        return totalItems;
    }
}















