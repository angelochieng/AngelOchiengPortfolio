// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
/**@author Angel Ochieng 906880673
 * @version 2023.09.18
 */
package game;
import student.TestCase;
import student.TestableRandom;
/**
* @author Angel Ochieng
* @version 2023.09.18
*/
/**
 * test class for simplearrayTest 
 */
public class SimpleArrayBagTest extends TestCase {
    /**
    * Sets up test methods 
    */

    public void setUp() {
        SimpleArrayBag<String> bag = new SimpleArrayBag<>();
        bag.add("red circle");
        bag.add("red square");
    }
    /**
     * tests the add method
     */

    public void testAdd() {
    	SimpleArrayBag<String> bag1 = new SimpleArrayBag<>();
        bag1.add("red circle");
        assertTrue(bag1.add("red square"));
        assertTrue(bag1.add("blue circle"));
        assertEquals(3, bag1.getCurrentSize());
        
    }
    /**
     * tests the getcurrentSize
     */
    public void testGetCurrentSize() {
        SimpleArrayBag<String> bag2 = new SimpleArrayBag<>();
    	bag2.add("blue circle");
    	assertEquals(1, bag2.getCurrentSize());
    }
    /**
     * tests the isEmpty method
     */
    public void testIsEmpty() {
        SimpleArrayBag<String> bag3 = new SimpleArrayBag<>();
        assertTrue(bag3.isEmpty());
        bag3.add("blue square");
        assertFalse(bag3.isEmpty());
    }
    /**
     * tests the pick method
     */
    public void testPick() {
    	TestableRandom.setNextInts(0, 42, 7);
        SimpleArrayBag<String> bag4 = new SimpleArrayBag<>();
        assertNull(bag4.pick());
        bag4.add("blue square");
        bag4.add("red circle");
        String picked = bag4.pick();
        assertNotNull(picked);
        assertEquals("blue square", picked);

    }
    /**
     * tests the remove method
     */
    public void testRemove() {
        SimpleArrayBag<String> bag5 = new SimpleArrayBag<>();
        bag5.add("red circle");
        bag5.add("blue circle");
        bag5.add("red square");
        assertTrue(bag5.remove("red circle"));
        assertEquals(bag5.getCurrentSize(), 2);
        String x = "red circle";
        assertFalse(bag5.remove(x));
        String y = "blue circle";
        assertTrue(bag5.remove(y));
        
    }

}
