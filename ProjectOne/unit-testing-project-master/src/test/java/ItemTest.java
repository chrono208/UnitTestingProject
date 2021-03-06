import static org.junit.jupiter.api.Assertions.*;

import csc4700.CartItem;
import csc4700.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Item item = new Item();
    private Item lemon = new Item();
    private Item banana = new Item();
    private CartItem c1 = null;

    @Test
    public void testEqualsNull() throws NullPointerException {
        Item i2 = null;
        banana.setName("Banana");
        banana.setCost(3);
        banana.setDescription("Long and curved.");
        try {
            boolean um = item.equals(getClass());
            assertEquals(false, um);
        }
        catch (NullPointerException e){
            //Expected
        }
    }

    @Test
    public void testEqualsF() {
        lemon.setName("Lemon");
        lemon.setCost(2);
        lemon.setDescription("Sour.");
        banana.setName("Banana");
        banana.setCost(3);
        banana.setDescription("Long and curved.");
        boolean um = lemon.equals(banana);
        assertEquals(false, um);
    }

    @Test
    public void testEqualsT() {
        lemon.setName("Lemon");
        lemon.setCost(2);
        lemon.setDescription("Sour.");
        banana.setName("Lemon");
        banana.setCost(2);
        banana.setDescription("Sour.");
        boolean um = lemon.equals(banana);
        assertEquals(true, um);
    }

    @Test
    public void testHashCodeNS() {
        item.setName("Lettuce");
        int lettuce = item.hashCode();
        lemon.setName("Lemon");
        int lemons = lemon.hashCode();
        assertNotSame(lettuce, lemons);
    }//TSetHash

    @Test
    public void testHashCodeNE() {
        item.setName("Lettuce");
        item.setCost(2);
        item.setDescription("Out of left field.");
        int lettuce = item.hashCode();
        lemon.setName("Lemon");
        lemon.setCost(2);
        lemon.setDescription("Into right.");
        int lemons = lemon.hashCode();
        assertNotEquals(lettuce, lemons);
    }//TSetHash

    @Test
    public void testGetName() {
        item.setName("Pineapple");
        item.setCost(2);
        item.setDescription("'s Belong On Pizza!");
        String name = item.getName();
        assertEquals("Pineapple", name);
    }//TGetName

    @Test
    public void testGetNameNull() {
        item.setName(null);
        item.setCost(2);
        item.setDescription("I'm nullin.");
        String name = item.getName();
        assertEquals(null, name);
    }//TGetName

    @Test
    public void testSetNameNull() {
        item.setName(null);
        item.setCost(2);
        item.setDescription("A nullified description.");
        String apple = item.getName();
        assertNull(null, apple);
    }//TSetName

    @Test
    public void testSetName() {
        item.setName("Papa John");
        item.setCost(2);
        item.setDescription("Papa Louie's cousin and little caesars' nephew.");
        String apple = item.getName();
        assertEquals("Papa John", apple);
    }//TSetName

    @Test
    public void testGetCost() {
        item.setName("Lime");
        item.setCost(33);
        item.setDescription("The original cringe maker.");
        int gotCost = item.getCost();
        assertEquals(33, gotCost);
    }//TGetCost

    @Test
    public void testGetNoCost() {
        item.setName("Lime");
        item.setCost(0);
        item.setDescription("Snot Cannon.");
        int gotCost = item.getCost();
        assertEquals(0, gotCost);
    }//TGetCost

    @Test
    public void testGetNegCost() {
        item.setName("Lime");
        item.setCost(-33);
        item.setDescription("Better Business Practices.");
        int gotCost = item.getCost();
        assertEquals(-33, gotCost);
    }//TGetCost

    @Test
    public void testSetCost() {
        item.setName("Apple");
        item.setCost(50);
        item.setDescription("Crisp.");
        int apple = item.getCost();
        assertEquals(50, apple);
    }//TSetCost

    @Test
    public void testNegSetCost() {
        item.setName("Apple");
        item.setCost(-1);
        item.setDescription("We pay you!");
        int apple = item.getCost();
        assertEquals(-1, apple);
    }//TSetCost

    @Test
    public void testSetNoCost() {
        item.setName("Apple");
        item.setCost(0);
        item.setDescription("Free.");
        int apple = item.getCost();
        assertEquals(0, apple);
    }//TSetCost

    @Test
    public void testGetDescription() {
        item.setName("Grape");
        item.setCost(2);
        item.setDescription("Round and juicy.");
        String desc = item.getDescription();
        assertEquals("Round and juicy.",desc);
    }//TGetDesc

    @Test
    public void testGetDescriptionNull() {
        item.setName("Grape");
        item.setCost(2);
        item.setDescription(null);
        String desc = item.getDescription();
        assertEquals(null,desc);
    }//TGetDesc

    @Test
    public void testSetDescription() {
        item.setName("Cucumber");
        item.setCost(2);
        item.setDescription("Long, hard, ribbed fruit of enjoyment.");
        String desc = item.getDescription();
        assertEquals("Long, hard, ribbed fruit of enjoyment.", desc);
    }//TSetDesc
    @Test

    public void testSetDescriptionNull() {
        item.setName("Cucumber");
        item.setCost(2);
        item.setDescription(null);
        String desc = item.getDescription();
        assertNull(null, desc);
    }//TSetDesc
}//Class
