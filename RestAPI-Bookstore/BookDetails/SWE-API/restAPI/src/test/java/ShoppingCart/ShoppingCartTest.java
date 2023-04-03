package ShoppingCart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartTest {

    private Inventory inventory;
    private   ShoppingCart cart;

    @BeforeEach
    void setUp() throws Exception {

        Item item1 = Item.builder().id("item-1").itemType(ItemType.BOOK).name("Master Your Emotions").price(BigDecimal.valueOf(10)).build();
        Item item2 = Item.builder().id("item-2").itemType(ItemType.BOOK).name("How To Win Friends & Influence People").price(BigDecimal.valueOf(10)).build();

        inventory.add(item1);
        inventory.add(item2);
        cart = new ShoppingCart(inventory);

    }

    @Test //Should add item to shopping cart
    public void Add_Shopping_Cart() {
        cart.addItem(new LineItem("item-1"));

        int totalItemCount = cart.totalNumberOfItems();

        Assertions.assertThat(totalItemCount).isEqualTo(1);
    }

    @Test
        // Should add multiple items to the cart
    void Add_multiple_items() {
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));

        int totalItemCount = cart.totalNumberOfItems();

        Assertions.assertThat(totalItemCount).isEqualTo(2);

    }

    @Test //Should add multiple quantity of the same item to the cart
    public void Add_multiple_quantity() {
        cart.addItem(new LineItem("item-1", 2));

        int totalItemCount = cart.totalNumberOfItems();

        Assertions.assertThat(totalItemCount).isEqualTo(2);

    }

    @Test // Should remove items from cart
    void Remove_item_from_cart (){
        cart.addItem(new LineItem("item-1"));
        cart.addItem(new LineItem("item-2"));

        cart.remove(new LineItem("item-1"));

        int totalItemCount = cart.totalNumberOfItems();


        Assertions.assertThat(totalItemCount).isEqualTo(1);

    }
     @Test //Should view  shopping list items in cart
    public void View_Cart (){
         cart.addItem(new LineItem("item-1", 4));
         cart.addItem(new LineItem("item-2", 3));

        List<LineItem> lineItems = cart.listItemsInCart();

         Assertions.assertThat(lineItems.get(0).totalPrice()).isEqualTo(BigDecimal.valueOf(40));
         Assertions.assertThat(lineItems.get(1).totalPrice()).isEqualTo(BigDecimal.valueOf(30));

    }
}