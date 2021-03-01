import static org.junit.jupiter.api.Assertions.*;
import csc4700.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Item item = new Item();
    private Item lemon = new Item();
    private Item banana = new Item();

    @Test
    public void testEquals() {
        lemon.setName("Lemon");
        banana.setName("Banana");
        boolean um = lemon.equals(banana);
        assertEquals(false, um);
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
        int lettuce = item.hashCode();
        lemon.setName("Lemon");
        int lemons = lemon.hashCode();
        assertNotEquals(lettuce, lemons);
    }//TSetHash

    @Test
    public void testGetName() {
        item.setName("Pineapple");
        String name = item.getName();
        assertEquals("Pineapple", name);
    }//TGetName

    @Test
    public void testSetNullName() {
        item.setName(null);
        String apple = item.getName();
        assertEquals(null, apple);
    }//TSetName

    @Test
    public void testGetCost() {
        item.setName("Lime");
        item.setCost(33);
        int gotCost = item.getCost();
        assertEquals(33, gotCost);
    }//TGetCost

    @Test
    public void testSetCost() {
        item.setName("Apple");
        item.setCost(50);
        int apple = item.getCost();
        assertEquals(50, apple);
    }//TSetCost

    @Test
    public void testGetDescription() {
        item.setName("Grape");
        item.setDescription("Round and juicy.");
        String desc = item.getDescription();
        assertEquals("Round and juicy.",desc);
    }//TGetDesc

    @Test
    public void testSetDescription() {
        item.setName("Cucumber");
        item.setDescription("Long, hard, ribbed fruit of enjoyment.");
        String desc = item.getDescription();
        assertEquals("Long, hard, ribbed fruit of enjoyment.", desc);
    }//TSetDesc
}//Class
