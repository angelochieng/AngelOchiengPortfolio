//Project 1 2025 Spring
// -- AngelOchieng 
package project1;
import bag.Bag;
import bag.BagInterface; 
import student.TestableRandom; 
/**
 * creates functionality for a randomly generated bag
 * @author Angel Ochieng
 * @version 2015.02.17, 2015.06.15
 */
public class DisplayCollection {
    /**
    * specifies allowed constant strings            
    */
    public static final String[] STRINGS = {"red circle", "blue circle", 
        "red square", "blue square"
    };
    private BagInterface<String> itemBag;
    /**
     * initializes and implements itemBag field        
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        TestableRandom random = new TestableRandom();
        int x = 5;
        int y = 16;
        int range = y - x;
        int count = random.nextInt(range) + x;
        for (int i = 0; i < count; i++) {
            String randomString = STRINGS[random.nextInt(STRINGS.length)];
            itemBag.add(randomString);
        }
    }
    /**
     *Implements the getItemBag Method
     * 
     * @return Returns the ItemBag.
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }
}
