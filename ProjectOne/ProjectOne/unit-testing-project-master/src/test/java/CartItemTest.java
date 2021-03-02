import csc4700.CartItem;
import csc4700.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    private Item item = new Item();
    private Item item2 = new Item();
    private CartItem carts = new CartItem(item);
    private CartItem carty = new CartItem(item);

    @Test
    public void testCartItem() {
        if(carts.getCount()==0) {
            carts.incrementCountByOne();
        }
        assertEquals(1, carts.getCount());
    }

    @Test
    public void testIncrementCountByOne() {
        carts.incrementCountByOne();
        assertEquals(1,carts.getCount());
    }

    @Test
    public void testDecrementCountByOne() {
        carts.setCount(3);
        carts.decrementCountByOne();
        assertEquals(2,carts.getCount());
    }

    @Test
    public void testEquals() {
        CartItem cart3 = new CartItem(item);
        boolean check = carts.equals(cart3);
        assertEquals(true, check);
    }

    @Test
    public void testHashCode() {
        item.setName("Pickle");
        item2.setName("Potato");
        carts.setItem(item);
        carty.setItem(item2);
        int num = carty.hashCode();
        int num2 = carty.hashCode();
        assertEquals(num, num2);
    }

    @Test
    public void testGetItem() {
        carts.setItem(item2);
        Item item1 = carts.getItem();
        assertEquals(item2, item1);
    }

    @Test
    public void testSetItem() {
        carts.setItem(item2);
        assertEquals(item2, carts.getItem());
    }

    @Test
    public void testGetCount() {
        int count = carts.getCount();
        assertEquals(0, count);
    }

    @Test
    public void testSetCount() {
        carts.setCount(10);
        int count = carts.getCount();
        assertEquals(10,count);
    }

}//Class.
