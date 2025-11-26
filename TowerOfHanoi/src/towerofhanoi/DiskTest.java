package towerofhanoi;
//Virginia Tech Honor Code Pledge:

//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673

import student.TestCase;

/**
 * Test class for disk class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class DiskTest extends TestCase {
    /**
     * sets up test cases
     */
    public void setUp() {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(7);
        Disk disk3 = new Disk(5);

    }

    /**
     * tests the constructor method
     */
    public void testConstructor() {
        Disk disk1 = new Disk(5);
        assertNotNull(disk1);
        assertEquals(5, disk1.getWidth());
    }

    /**
     * tests compareto method
     */
    public void testCompareTo() {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(7);
        Disk disk3 = new Disk(5);
        assertTrue(disk1.compareTo(disk2) < 0);
        assertTrue(disk2.compareTo(disk1) > 0);
        assertEquals(0, disk1.compareTo(disk3));
    }

    /**
     * tests tostring method
     */
    public void testToString() {
        Disk disk1 = new Disk(5);
        assertEquals("5", disk1.toString());
    }

    /**
     * tests the exception
     */
    public void testException() {
        Disk disk1 = new Disk(5);
        Exception exception = null;
        try {
            disk1.compareTo(null);
        } 
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
    }

    /**
     * tests the equals method
     */
    public void testEquals() {
        Disk disk1 = new Disk(5);
        Disk disk2 = new Disk(7);
        Disk disk3 = new Disk(5);
        assertTrue(disk1.equals(disk3));
        assertFalse(disk1.equals(disk2));
        assertFalse(disk1.equals(null));
        assertFalse(disk1.equals("cat"));
        assertFalse(disk1.equals(disk2));
        assertTrue(disk1.equals(disk1));
    }

}