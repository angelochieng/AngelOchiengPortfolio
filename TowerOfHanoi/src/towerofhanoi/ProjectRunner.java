package towerofhanoi;

//Virginia Tech Honor Code Pledge:
//Project 3 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
* The implementing the project runner class
*
* @author Angel Ochieng
* @version 03.17.2025
*/
public class ProjectRunner {
    /**
     * The main method for Tower of Hanoi 
     *@param args specifies number of disks 
     */ 
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        
        PuzzleWindow window = new PuzzleWindow(new HanoiSolver(disks));
       
    }
}
