package ShoppingCart;

import java.util.*;

public class ShoppingCart {

    private final Inventory inventory;
    private Map<String,LineItem> itemsInCart = new LinkedHashMap<>();

    public ShoppingCart(Inventory inventory) {
        this.inventory = inventory;

    }
    public void addItem(LineItem lineItem) {
        if(itemsInCart.containsKey(lineItem.getItemId())) {
            LineItem lineItemInCart = itemsInCart.get(lineItem.getItemId());
            lineItemInCart.increaseQuantityBy(lineItem.getQuantity());

        }else {

            Item item = inventory.get(lineItem.getItemId());
            lineItem.setName(item.getName());
            lineItem.setPrice(item.getPrice());
            this.itemsInCart.put(lineItem.getItemId(), lineItem);
        }
    }
    public int totalNumberOfItems() {
        int totalItems = 0;
        for(LineItem ShoppingLineItem : itemsInCart.values()) {
            totalItems += ShoppingLineItem.getQuantity();
        }
        return totalItems;
    }

    public void remove(LineItem lineItemToRemove) {
        boolean deleteLineItem = false;
        for(LineItem itemInCart : itemsInCart.values()){
            if(Objects.equals(itemInCart.getItemId(), lineItemToRemove.getItemId())) {
                if (lineItemToRemove.getQuantity() == itemInCart.getQuantity()) {
                    deleteLineItem = true;
                } else {
                    itemInCart.reduceQuantityBy(lineItemToRemove.getQuantity());
                }
            }
        }
        if (deleteLineItem) {
            this.itemsInCart.remove(lineItemToRemove.getItemId());
        }
    }

      public List<LineItem> listItemsInCart() {
        return  Collections.unmodifiableList(new ArrayList<>(this.itemsInCart.values()));
    }
}















