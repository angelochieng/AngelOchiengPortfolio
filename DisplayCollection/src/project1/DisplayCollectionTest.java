//Project 1 2025 Spring
// -- AngelOchieng 
package project1;
import bag.BagInterface; 
import student.TestableRandom;
import student.TestCase;
/**
 * Tests the methods in display collection class
 * @author Angel Ochieng
 * @version 2015.02.17, 2015.06.15
 */
public class DisplayCollectionTest extends TestCase {
    /**
    * sets up the method which is intentionally empty
    */
    public void setUp() {
        /**
        *  Method left intentionally empty due to empty fields
        */
    }
    /**
    * Tests the bag size for range 
    */
    public void testBagSize() {
        for (int i = 5; i <= 15; i++) {
            TestableRandom.setNextInts(i - 5);
            DisplayCollection dc = new DisplayCollection();
            BagInterface<String> dcBag = dc.getItemBag();
            assertEquals(i, i, dcBag.getCurrentSize());
        }
    }
    /**
    * Tests the bag contents to see if removed 
    * item is equal to legal strings 
    */
    public void testBagContents() {
        DisplayCollection dc = new DisplayCollection();
        BagInterface<String> itemBag = dc.getItemBag();
        int h = itemBag.getCurrentSize();
        assertTrue(itemBag.getCurrentSize() > 5);
        assertEquals(DisplayCollection.STRINGS.length, 4);
        DisplayCollection contents = new DisplayCollection();
        BagInterface<String> itembag2 = contents.getItemBag();
        itembag2.clear();
        for (int i = 0; i < DisplayCollection.STRINGS.length; i++) {
            itembag2.add(DisplayCollection.STRINGS[i]);
        }
        assertEquals(itembag2.getCurrentSize(), 4);
        while (itemBag.getCurrentSize() > 0) {
            String c = itemBag.remove();
            assertNotNull(c);
            assertTrue(itembag2.contains(c));	
        }
        assertEquals(itemBag.getCurrentSize(), 0);
        assertTrue(itemBag.isEmpty());	
    }
}		
