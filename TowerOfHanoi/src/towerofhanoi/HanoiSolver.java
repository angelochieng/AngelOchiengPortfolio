package towerofhanoi;

import java.util.Observable;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
* The implementing the HanoiSolver class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower center;
    private int numDisks;
    private Tower right; 
    /**
     * Initializes the Tower of Hanoi solver.
     * 
     * @param numDisks The number of disks to be solved.
     */

    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.center = new Tower(Position.CENTER);
        this.right = new Tower(Position.RIGHT);
    }
    /**
     * Returns the number of disks in the puzzle.
     * 
     * @return The number of disks.
     */
    public int disks() {
        return numDisks;
    }
    /**
     * returns disk at the given position.
     * 
     * @param pos The position of the tower.
     * @return The tower position.
     */
    public Tower getTower(Position pos) {
        switch(pos) {
            case LEFT:
                return left;
            case CENTER:
                return center;
            case RIGHT:
                return right;
            default:
                return center;
        }
    }
    /**
     * Returns string representation of towers.
     * 
     * @return A string containing all tower states.
     */
    public String toString() {
        return left.toString() + center.toString() + right.toString();
    }
    /**
     * Moves  disk from  source  to destination tower.
     * Notifies observers of the move.
     * 
     * @param source The tower from which the disk is moved.
     * @param destination The tower to which the disk is moved.
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        setChanged();
        notifyObservers(destination.position());
    }
    /**
     * Solves the Tower of Hanoi problem 
     * 
     * @param currentDisks The number of disks to move.
     * @param startPole The source tower.
     * @param tempPole The auxiliary tower.
     * @param endPole The destination tower.
     */
    private void solveTowers(int currentDisks, Tower startPole, 
            Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
        
    }
    /**
     * starts solving process.
     */
    public void solve() {
        solveTowers(numDisks, left, center, right);
    }
    
}