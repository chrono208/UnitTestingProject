import static org.junit.jupiter.api.Assertions.*;

import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart sc = new ShoppingCart();
    private Item celery = new Item();
    private Item broccoli = new Item();
    private Item corn = new Item();

    @Test
    public void testAddItem() {
        //sc.addItem(corn);
        //assertEquals(corn, sc.getCartItems());
    }

    @Test
    public void testDeleteItem() {
        sc.addItem(broccoli);
        int bro = broccoli.hashCode();
        sc.deleteItem(broccoli);
        assertEquals(bro, sc.findCartItem(broccoli));
    }

    @Test
    public void testFindCartItem() {
        broccoli.setName("Broccoli");
        sc.addItem(broccoli);
        sc.addItem(celery);
        assertEquals(1, sc.findCartItem(broccoli));
    }

    @Test
    public void testGetCartItems() {
        sc.addItem(corn);
        sc.addItem(celery);
        assertEquals(corn, sc.getCartItems());
    }
}//Class
