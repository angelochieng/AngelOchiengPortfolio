package towerofhanoi;

import java.util.EmptyStackException;

import student.TestCase;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 
/**
* The implementing the LinkedStack class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class HanoiTest extends TestCase {
    /**
     * Sets up the test cases.
     */
    public void setUp() {
        HanoiSolver solver = new HanoiSolver(3);
        Disk disk1 = new Disk(50);
        Disk disk2 = new Disk(70);
        Disk disk3 = new Disk(50);
    }
    /**
     * event handler for number of disks.
     */
    public void testDisks() {
        HanoiSolver solver = new HanoiSolver(3);
        assertEquals(3, solver.disks());
    }
    /**
     * tests theGetTower Method
     */
    public void testGetTower() {
        HanoiSolver solver = new HanoiSolver(3);
        assertNotNull(solver.getTower(Position.LEFT));
        assertNotNull(solver.getTower(Position.CENTER));
        assertNotNull(solver.getTower(Position.RIGHT));
    }
    /**
     * tests the tostring method
     */
    public void testToString() {
        HanoiSolver solver = new HanoiSolver(3);
        Disk disk1 = new Disk(50);
        assertEquals("[][][]", solver.toString());
        solver.getTower(Position.LEFT).push(disk1);
        assertEquals("[50][][]", solver.toString());
    }
    /**
     * tests the Move method
     */
    public void testMove() {
        HanoiSolver solver = new HanoiSolver(3);
        Disk disk1 = new Disk(50);
        Tower left = solver.getTower(Position.LEFT);
        Tower right = solver.getTower(Position.RIGHT);
        Exception exception = null;
        try {
            left.pop();
        } 
        catch (EmptyStackException e) {
            exception = e;
        }
        assertNotNull(exception);
        
        
    }
    /**
     * tests the solve method
     */
    public void testSolve() {
        HanoiSolver solver = new HanoiSolver(3);
        Disk disk1 = new Disk(30);
        Disk disk2 = new Disk(50);
        Disk disk3 = new Disk(70);
        Tower left = solver.getTower(Position.LEFT);
        Tower right = solver.getTower(Position.RIGHT);
        left.push(disk3);
        left.push(disk2);
        left.push(disk1);
        solver.solve();
        assertTrue(left.isEmpty());
        assertEquals(disk1, right.pop());
        assertEquals(disk2, right.pop());
        assertEquals(disk3, right.pop());

    }
    
}
