import static org.junit.jupiter.api.Assertions.*;

import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.exceptions.InvalidCountException;
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
    public void testNullAddItem() {
        Item i1 = null;
        try {
            sc.addItem(i1);
            fail("Expected exception");
        }
        catch (NullPointerException e) {
            //Expected.
            try {
                sc.deleteItem(i1);
            }
            catch (NullPointerException e1) {
                //Expected.
            }
        }
    }

    @Test
    public void testDeleteItem() {
        corn.setName("Broccoli");
        sc.addItem(broccoli);
        sc.deleteItem(broccoli);
        assertEquals(null, sc.findCartItem(broccoli));
    }

    @Test
    public void testDeleteItemCount() {
        broccoli.setName("Broccoli");
        corn.setName("Corn");
        celery.setName("Celery");
        ShoppingCart sc1 = new ShoppingCart();

        sc.addItem(celery);
        sc.addItem(celery);
        sc.addItem(celery);

        sc1.addItem(celery);
        sc1.addItem(celery);
        sc1.addItem(celery);

        sc.findCartItem(celery);
        sc.deleteItem(celery);
        sc.deleteItem(celery);
        sc.deleteItem(celery);
        sc.deleteItem(celery);
        sc.deleteItem(celery);
        assertNotSame(sc, sc1);
    }

    @Test
    public void testDeleteNullItem() throws NullPointerException {

        celery.setName("Celery");
        celery.setCost(2);
        celery.setDescription("Green n hard");
        sc.addItem(celery);
        CartItem cu = new CartItem(celery);
        cu.setItem(null);
        cu.setCount(1);
        try {
            sc.deleteItem(cu.getItem());
            fail("Expected exception");
        }
        catch (NullPointerException e) {
            //Expected.
        }
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
