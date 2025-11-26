package towerofhanoi;
import java.awt.Color;
import cs2.*;
import student.TestableRandom;
//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
* The implementing the disk class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class Disk extends Shape implements Comparable<Disk> {
    /**
    * Instantiating the height parameter.        
    */
    public static final int DISK_HEIGHT = 15;
    /**
     * making a new Disk object 
     * initializing the disk to run with a 
     * random background and specializing the bounds
     * @param width The width of the disk.      
     */
    public Disk(int width) {
        super(0, 0, width, DISK_HEIGHT);
        TestableRandom random = new TestableRandom();
        Color randomColor = new Color(random.nextInt(256), random.nextInt(256), 
                random.nextInt(256));
        this.setBackgroundColor(randomColor);
    }
    /**
     *Sets up the width comparison bounds  
     *@throws IllegalArgumentException if 
     *bounds are beyond specified
     *@param otherDisk The disk to be compared.
     * @return 0 if equal     
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        } 
        else if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
            
    }
    /**
     * returns string representation of the width
     * @return a string representing the disk
     */
    public String toString() {
        return this.getWidth() + "";
    }
    /**
     * Specifying what makes a disk equal.
     * @return equal disk length or not. 
     * @param obj to be compared        
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Disk other = (Disk) obj;
        return this.getWidth() == other.getWidth();
    } 

    
    
}
