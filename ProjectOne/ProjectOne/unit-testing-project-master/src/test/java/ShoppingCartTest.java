import static org.junit.jupiter.api.Assertions.*;

import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart sc = new ShoppingCart();
    private Item celery = new Item();
    private Item broccoli = new Item();
    private Item corn = new Item();
    private CartItem ci = new CartItem(broccoli);

    @Test
    public void testAddItem() {
        corn.setName("Corn");
        sc.addItem(corn);
        CartItem c1 = sc.findCartItem(corn);
        Item i1 = c1.getItem();
        String name = i1.getName();
        assertEquals("Corn", name);
    }

    @Test
    public void testDeleteItem() {
        corn.setName("Broccoli");
        sc.addItem(broccoli);
        sc.deleteItem(broccoli);
        assertEquals(null, sc.findCartItem(broccoli));
    }

    @Test
    public void testFindCartItem() {
        celery.setName("Celery");
        sc.addItem(celery);
        CartItem c2 = sc.findCartItem(celery);
        Item i2 = c2.getItem();
        String s2 = i2.getName();
        assertEquals("Celery", s2);
    }

    @Test
    public void testGetCartItems() {
        corn.setName("Corn");
        celery.setName("Celery");
        CartItem c3 = new CartItem(corn);
        CartItem c4 = new CartItem(celery);
        sc.addItem(corn);
        sc.addItem(celery);
        List<CartItem> lci = new ArrayList<>();
        lci.add(c3);
        lci.add(c4);
        assertEquals(lci,sc.getCartItems());
    }
}//Class
