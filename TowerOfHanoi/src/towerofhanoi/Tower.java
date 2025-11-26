package towerofhanoi;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
* The implementing the tower class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class Tower extends LinkedStack<Disk> {
    /**
     * initializes position variable   
     */
    private Position position;
    /**
     * create stack and stores position
     * @param position The position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }
    /**
     * @return tower position   
     */
    public Position position() {
        return position;
    }
    /**
     * @throws IllegalArgumentException if null 
     * @throws IllegalStateException if null
     * @param disk to be added to tower  
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || peek().compareTo(disk) > 0) {
            super.push(disk); 
        } 
        else {
            throw new IllegalStateException();
        }
    }
}
