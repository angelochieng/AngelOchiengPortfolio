// Virginia Tech Honor Code Pledge:
// This is a submission for project 2 (Spring 2025)
// As a Hokie, I will conduct myself with honor and 
//integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.


package game;
/**
* @author Angel Ochieng
* @version 2023.09.18
*/


public class ProjectRunnner  {
    /**
     * @param args initiates the project window
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape game = new WhackAShape(args);
		} 
        else {
			WhackAShape game = new WhackAShape();
		}
	}

}	