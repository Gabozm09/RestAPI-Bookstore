package ShoppingCart;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ShoppingCartTest {


    @BeforeEach
    void setUp() throws Exception {
        Item item1 =  Item.builder().id("ite-1").itemType(ItemType.BOOK).name("Master Your Emotions").price(BigDecimal.valueOf(4000)).build();



        Inventory inventory = new Inventory();
        ShoppingCart cart = new ShoppingCart();

    }

    @Test
     public void Add_Shopping_Cart () {

       Inventory inventory = new Inventory();
       ShoppingCart cart = new ShoppingCart();

//       cart.addItem(new LineItem(i));



        int totalItemCount = cart.totalNumberOfItems();

        Assertions.assertThat(totalItemCount).isEqualTo(1);


    }

    @Test
    void Add_multiple_items () {
        ShoppingCart cart = new ShoppingCart();
   //     cart.addItem (new LineItem(new ShoppingCart.ShoppingItemBuilder().setId("item-1").setName("Master Your Emotions").setItemType(ItemType.BOOK).setPrice(BigDecimal.valueOf(4000)).createShoppingItem()));

        int totalItemCount = cart.totalNumberOfItems();

        Assertions.assertThat(totalItemCount).isEqualTo(1);

    }
}