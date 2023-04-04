package ShoppingCart;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map< String, Item> items = new HashMap<>();

    public void add(Item item){
        this.items.put(item.getId(), item);
    }


    public Item get(String id){
        return items.get(id);

    }

}
