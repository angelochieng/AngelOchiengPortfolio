package towerofhanoi;

import student.TestCase;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
 * The implementing the LinkedStack class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
public class TowerTest extends TestCase {
    /**
     * sets up test cases
     */
    public void setUp() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk1 = new Disk(50);
        Disk disk2 = new Disk(70);
        Disk disk3 = new Disk(50);

    }

    /**
     * m* tests constructor
     */
    public void testConstructor() {
        Tower tower = new Tower(Position.LEFT);
        assertEquals(Position.LEFT, tower.position());
    }

    /**
     * tests push method
     */
    public void testPush() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk1 = new Disk(50);
        Exception exception = null;
        try {
            tower.push(null);
        } 
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);
        tower.push(disk1);
        assertEquals(disk1, tower.peek());
    }

    /**
     * tests the exception
     */
    public void testException() {
        Tower tower = new Tower(Position.LEFT);
        Disk disk1 = new Disk(50);
        Disk disk2 = new Disk(70);
        tower.push(disk1);
        Exception exception = null;
        try {
            tower.push(disk2);
        } 
        catch (IllegalStateException e) {
            exception = e;
        }
        assertNotNull(exception);

    }

}
