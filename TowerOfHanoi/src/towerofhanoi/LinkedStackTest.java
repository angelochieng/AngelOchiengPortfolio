package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673

import java.util.EmptyStackException;



import student.TestCase;
/**
* Test class for linked stack class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class LinkedStackTest extends TestCase {
    /**
     *initializing linkedstack 
     */
    private LinkedStack<Integer> stack;
    /**
    * sets up test cases 
    */
    public void setUp() {
        stack = new LinkedStack<>();
    }
    /**
     *tests clear method 
     */
    
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    /**
     *tests isempty method 
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(6);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
        
    }
    /**
     *tests peek method 
     */
    public void testPeek() {
        Exception exception = null;
        try {
            stack.peek();
        } 
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        stack.push(4);
        stack.push(90);
        stack.peek();
        
    }
    /**
     *tests pop method 
     */
    public void testPop() {
        Exception exception = null;
        try {
            stack.pop();
        } 
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        stack.push(4);
        stack.push(5);
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
    /**
     *tests push method 
     */
    public void testPush() {
        assertEquals(0, stack.size());
        stack.push(9);
        assertEquals(1, stack.size());
    }
    /**
     *tests size method 
     */
    public void testSize( ) {
        assertEquals(0, stack.size());
        stack.push(10);
        assertEquals(1, stack.size());
    }
    /**
     *tests tostring method 
     */
    public void testToString() {
        assertEquals("[]", stack.toString());

        stack.push(11);
        stack.push(12);
        stack.push(13);
        assertEquals("[13, 12, 11]", stack.toString());
    
    }
}

