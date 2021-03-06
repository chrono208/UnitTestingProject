import csc4700.CartItem;
import csc4700.Item;
import csc4700.exceptions.InvalidCountException;
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
    public void testEqualsFalse() throws NullPointerException {
        CartItem cart3 = null;
        try {
            boolean check = carts.equals(cart3);
            assertEquals(false, check);
        }
        catch (NullPointerException e) {
        }
    }

    @Test
    public void testNotEquals() {
        item2.setName("Plum");
        item.setName("Raspberry");
        carts.setItem(item);
        carty.setItem(item2);
        boolean check = carts.equals(carty);
        assertSame(false, check);
    }

    @Test
    public void testEqualsNull() throws NullPointerException {
        Item i1 = null;
        CartItem cart1 = null;
        item.setName("Banana");
        item.setCost(3);
        item.setDescription("Long and curved.");
        CartItem cart2 = new CartItem(item);
        try {
            boolean um = cart2.equals(getClass());
            assertEquals(false, um);
        }
        catch (NullPointerException e){
            //Expected
        }
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
    public void testHashCodeNull() {
        Item i5 = null;
        Item i6 = null;
        carts.setItem(i5);
        carty.setItem(i6);
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

    @Test
    public void testSetCountL() {
        int count = 0;
        try {
            carts.setCount(-12);
            count = carty.getCount();
            fail("Expected exception");
        }
        catch (InvalidCountException e) {
            //Expected
            assertEquals(0, count);
        }
    }

}//Class.
