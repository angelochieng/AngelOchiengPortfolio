// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.

package game;
import bag.Node;

import student.TestCase;
import student.TestableRandom;
/**
* @author Angel Ochieng
* @version 2023.09.18
*/
/**
 * test class for simplelinkedtest 
 */

public class SimpleLinkeDBagTest extends TestCase {
    /**
    * Sets up test methods 
    */
	public void setUp() {
	    SimpleLinkedBag<String> bag = new SimpleLinkedBag<>();
	    bag.add("red circle");
	    bag.add("red square");
	    bag.add("bluesquare");
	}
	/**
     * tests the add method
     */

	public void testAdd() {
        SimpleLinkedBag<String> bag1 = new SimpleLinkedBag<>();
        bag1.add("red circle");
        assertEquals(1, bag1.getCurrentSize());
	}
	 /**
     * tests the getcurrentSize
     */
	public void testGetCurrentSize() {
	    SimpleLinkedBag<String> bag2 = new SimpleLinkedBag<>();
	    bag2.add("Blue Circle");
	    assertEquals(1, bag2.getCurrentSize());
	}
	/**
     * tests the isEmpty method
     */
	public void testIsEmpty() {
		SimpleLinkedBag<String> bag3 = new SimpleLinkedBag<>();
		assertTrue(bag3.isEmpty());
		bag3.add("red square");
		assertFalse(bag3.isEmpty());
	}
	/**
     * tests the pick method
     */
	public void testPick() {
		TestableRandom.setNextInts(0, 42, 7);
        SimpleLinkedBag<String> bag6 = new SimpleLinkedBag<>();
        assertNull(bag6.pick());
        SimpleLinkedBag<String> bag4 = new SimpleLinkedBag<>();
        bag4.add("blue square");
        bag4.add("red circle");
        assertNotNull(bag4.pick());
        assertEquals(bag4.pick(), "red circle");
        String anEntry = bag4.pick();
        Node<String> newNode = bag4.getReferenceTo(anEntry);
        assertNotNull(newNode);
        bag4.add("red circle");
        bag4.add("blue circle");
        String chosen = bag4.pick();
        Node<String> newNode2 = bag4.getReferenceTo(chosen);
        assertNotNull(newNode2);
	}
	/**
     * tests the remove method
     */
	public void testRemove() {
		SimpleLinkedBag<String> bag5 = new SimpleLinkedBag<>();
	    bag5.add("red circle");
	    bag5.add("blue circle");
	    bag5.add("red square");
	    assertTrue(bag5.remove("red circle"));
	    assertEquals(bag5.getCurrentSize(), 2);
		
	}
	
}
