import static org.junit.jupiter.api.Assertions.*;

import csc4700.Backup;
import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.exceptions.SerializedFormatException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BackupTest {

    private Item plum = new Item();
    private Item cherry = new Item();
    private Item papaya = new Item();
    private ShoppingCart sc = new ShoppingCart();
    private Backup backup = new Backup();
    private String filename;

    @Test
    public void testSerializeShoppingCart() {
        plum.setName("Plum");
        plum.setCost(2);
        plum.setDescription("For old people.");

        cherry.setName("Cherry");
        cherry.setCost(1);
        cherry.setDescription("For the consenting.");

        papaya.setName("Papaya");
        papaya.setCost(3);
        papaya.setDescription("Papayas contain an enzyme called papain that aids digestion; in fact, it can be used as a meat tenderizer.");

        sc.addItem(plum);
        sc.addItem(cherry);
        sc.addItem(papaya);
        String cartList = backup.serializeShoppingCart(sc);

        assertEquals("Plum,2,For old people.,1"+ Backup.LINE_SEPARATOR +"Cherry,1,For the consenting.,1"+ Backup.LINE_SEPARATOR +"Papaya,3,Papayas contain an enzyme called papain that aids digestion; in fact, it can be used as a meat tenderizer.,1" + Backup.LINE_SEPARATOR, cartList);
    }


    @Test
    public void testDeserializeShoppingCart() throws SerializedFormatException {
        plum.setName("Plum");
        plum.setCost(2);
        plum.setDescription("For old people.");

        cherry.setName("Cherry");
        cherry.setCost(1);
        cherry.setDescription("For the consenting.");

        sc.addItem(plum);
        sc.addItem(cherry);
        sc.addItem(cherry);
        sc.addItem(cherry);

        String cartList = backup.serializeShoppingCart(sc);
        ShoppingCart sc1 = backup.deserializeShoppingCart(cartList);
        String c1 = backup.serializeShoppingCart(sc);
        String c2 = backup.serializeShoppingCart(sc1);
        assertEquals(c1, c2);
    }

    @Test
    public void testDeserializeShoppingCartIF() throws SerializedFormatException {
        try {
            ShoppingCart sc1 = backup.deserializeShoppingCart("stuffing");
            fail("Exception expected.");
        }
        catch(SerializedFormatException e){
            //Exception.
        }
    }//Deserialized.

    @Test
    public void testNullDeserializeShoppingCart() throws NullPointerException, SerializedFormatException {

        try {
            String cartList = null;
            ShoppingCart sc1 = backup.deserializeShoppingCart(cartList);
            fail("Exception expected.");
        }
        catch (NullPointerException e){
            //Exception.
        }
    }

    @Test
    public void saveShoppingCart() throws IOException, SerializedFormatException  {
        plum.setName("Plum");
        plum.setCost(2);
        plum.setDescription("For old people.");

        cherry.setName("Cherry");
        cherry.setCost(1);
        cherry.setDescription("For the consenting.");

        sc.addItem(plum);
        sc.addItem(cherry);

        File path = File.createTempFile("BackupTest", "");
        this.filename = path.getAbsolutePath();

        backup.saveShoppingCart(sc, path);
        ShoppingCart sc3 = backup.loadShoppingCart(path);
        String cartList = backup.serializeShoppingCart(sc3);
        assertEquals("Plum,2,For old people.,1" + Backup.LINE_SEPARATOR + "Cherry,1,For the consenting.,1" + Backup.LINE_SEPARATOR, cartList);
        File f = new File(this.filename);
        f.delete();
    }





    @Test
    public void testSaveShoppingCartEx() throws IOException, SerializedFormatException {
        cherry.setName("Cherry");
        cherry.setCost(1);
        cherry.setDescription("For the consenting.");

        sc.addItem(cherry);
        ShoppingCart sc2 = new ShoppingCart();
        sc2.addItem(cherry);
        sc2.addItem(plum);

        File path = new File("Testing.txt");
        this.filename = path.getAbsolutePath();

        try {
            backup.saveShoppingCart(sc2, path);
            backup.saveShoppingCart(sc, path);
        }
        catch (IOException e) {
            //Comments
        }
        ShoppingCart sc3 = backup.loadShoppingCart(path);
        assertEquals(1, cherry.getCost());
    }


    @Test
    public void testLoadShoppingCart() throws IOException, SerializedFormatException {
        plum.setName("Plum");
        plum.setCost(2);
        plum.setDescription("For old people.");

        cherry.setName("Cherry");
        cherry.setCost(1);
        cherry.setDescription("For the consenting.");

        sc.addItem(plum);
        sc.addItem(cherry);

        File path = File.createTempFile("BackupTest", "");
        this.filename = path.getAbsolutePath();

        backup.saveShoppingCart(sc, path);
        ShoppingCart sc3 = backup.loadShoppingCart(path);
        String cartList = backup.serializeShoppingCart(sc3);
        assertEquals("Plum,2,For old people.,1" + Backup.LINE_SEPARATOR + "Cherry,1,For the consenting.,1" + Backup.LINE_SEPARATOR, cartList);
        File f = new File(this.filename);
        f.delete();

    }
}//Class.